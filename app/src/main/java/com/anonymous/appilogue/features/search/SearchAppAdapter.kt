package com.anonymous.appilogue.features.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anonymous.appilogue.R
import com.anonymous.appilogue.databinding.ItemInstalledAppBinding
import com.anonymous.appilogue.model.InstalledApp

class SearchAppAdapter : ListAdapter<InstalledApp, SearchAppAdapter.SearchAppViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAppViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemInstalledAppBinding>(
            layoutInflater, R.layout.item_installed_app, parent, false)
        return SearchAppViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchAppViewHolder, position: Int) {
        if (position < itemCount) {
            holder.bind(getItem(position))
        }
    }

    inner class SearchAppViewHolder(
        private val binding: ItemInstalledAppBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position < itemCount) {
                    val item = getItem(position)

                    binding.root.context.startActivity()
                }
            }
        }

        fun bind(installedApp: InstalledApp) {
            binding.apply {
                item = installedApp
                executePendingBindings()
            }
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<InstalledApp>() {

            override fun areItemsTheSame(oldItem: InstalledApp, newItem: InstalledApp): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: InstalledApp, newItem: InstalledApp): Boolean {
                return oldItem == newItem
            }
        }
    }
}