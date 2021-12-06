package com.anonymous.appilogue.features.search

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.anonymous.appilogue.R
import com.anonymous.appilogue.databinding.FragmentSearchBinding
import com.anonymous.appilogue.features.base.BaseFragment
import com.anonymous.appilogue.features.main.MainActivity
import com.anonymous.appilogue.utils.showKeyboardUp
import com.jakewharton.rxbinding4.view.focusChanges
import com.jakewharton.rxbinding4.widget.textChanges
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class SearchAppFragment
    : BaseFragment<FragmentSearchBinding, SearchAppViewModel>(R.layout.fragment_search) {

    override val viewModel: SearchAppViewModel by viewModels()

    private val searchAppAdapter: SearchAppAdapter by lazy {
        val mainActivity = activity as MainActivity
        SearchAppAdapter(mainActivity.viewModel) {
            mainActivity.navigateTo(R.id.action_searchAppFragment_to_reviewSelectorFragment)
        }
    }

    private var disposable: Disposable? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind {
            vm = viewModel
        }

        initRecyclerView()
        initView()
        initObserver()
    }

    private fun initRecyclerView() {
        binding.searchAppRecyclerView.apply {
            adapter = searchAppAdapter
        }
    }

    private fun initView() {
        bind {
            searchEditTextView.focusChanges()
                .subscribe { focus ->
                    if (focus) {
                        searchInputLayout.isHintEnabled = false
                        context?.showKeyboardUp()
                    }
                }
            disposable = searchEditTextView.textChanges()
                .debounce(300L, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { keyword ->
                    viewModel.search(keyword.toString())
                }
            toolbarLeftIconView.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    private fun initObserver() {
        viewModel.searchResult.observe(viewLifecycleOwner) { searchResult ->
            searchAppAdapter.submitList(searchResult)
        }
    }

    override fun onDestroyView() {
        disposable?.dispose()
        super.onDestroyView()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (activity as MainActivity).hideBottomNavigation()
    }
}