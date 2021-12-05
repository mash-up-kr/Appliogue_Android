package com.anonymous.appilogue.features.home.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.preference.PreferenceManager
import com.anonymous.appilogue.R
import com.anonymous.appilogue.databinding.FragmentOnboardingBinding
import com.anonymous.appilogue.features.base.BaseFragment
import com.anonymous.appilogue.features.home.Focus
import com.anonymous.appilogue.features.home.HomeViewModel
import com.anonymous.appilogue.features.main.MainViewModel

class OnboardingFragment :
    BaseFragment<FragmentOnboardingBinding, OnboardingViewModel>(R.layout.fragment_onboarding) {

    val mainViewModel: MainViewModel by activityViewModels()
    val homeViewModel: HomeViewModel by activityViewModels()
    override val viewModel: OnboardingViewModel by activityViewModels()

    private var onboardingEventIndex = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.disableClickBottomNavigation()
        bind {
            onboardingViewModel = viewModel
        }
        initView()
    }

    private fun initView() {
        setNextOnboardingEvent()
        binding.tvNext.setOnClickListener {
            setNextOnboardingEvent()
        }
    }

    private val onboardingEvents = listOf(
        (R.string.onboarding_planet_description to R.string.planet) to ({
            homeViewModel.setStarsAlpha(
                Focus.OnPlanet,
                UNFOCUSED_STAR_ALPHA
            )
        }),
        (R.string.onboarding_black_hole_description to R.string.black_hole) to ({
            homeViewModel.setStarsAlpha(
                Focus.OnBlackHole,
                UNFOCUSED_STAR_ALPHA
            )
        }),
        (R.string.onboarding_white_hole_description to R.string.white_hole) to ({
            homeViewModel.setStarsAlpha(
                Focus.OnWhiteHole,
                UNFOCUSED_STAR_ALPHA
            )
        }),
        (R.string.onboarding_space_dust_description to R.string.onboarding_nickname) to ({
            homeViewModel.setStarsAlpha(
                Focus.OnSpaceDust,
                UNFOCUSED_STAR_ALPHA
            )
        }),
        (R.string.onboarding_space_description to R.string.onboarding_my_space) to ({
            homeViewModel.setStarsAlpha(
                Focus.None,
                UNFOCUSED_STAR_ALPHA
            )
        })
    )

    private fun setNextOnboardingEvent() {
        if (onboardingEventIndex < onboardingEvents.size) {
            val event = onboardingEvents[onboardingEventIndex++]
            viewModel.setDescriptionRes(event.first.first, event.first.second)
            event.second.invoke()
        } else {
            finishOnboarding()
        }
    }

    private fun finishOnboarding() {
        parentFragmentManager.commit {
            remove(this@OnboardingFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainViewModel.enableClickBottomNavigation()
        if (onboardingEventIndex == onboardingEvents.size)
            PreferenceManager.getDefaultSharedPreferences(context).edit().apply {
                putBoolean(COMPLETED_ONBOARDING, true)
                apply()
            }
    }

    companion object {
        const val COMPLETED_ONBOARDING = "ONBOARDING"
        const val UNFOCUSED_STAR_ALPHA = 0.3f
    }
}