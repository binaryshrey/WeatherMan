package dev.shreyansh.weatherman.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.shreyansh.weatherman.databinding.SearchListItemBinding
import dev.shreyansh.weatherman.network.response.CitySearchResponse



class SearchRecyclerAdapter( val onClickListener: OnClickListener) : ListAdapter<CitySearchResponse, SearchRecyclerAdapter.ViewHolder>(DiffUtilItemCallBackSearch()) {


    class ViewHolder private constructor(val binding : SearchListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CitySearchResponse) {
            binding.search = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SearchListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(item)
        }
        holder.bind(item)
    }

    class OnClickListener(val clickListener: (search: CitySearchResponse) -> Unit) {
        fun onClick(search: CitySearchResponse) = clickListener(search)
    }

}


class DiffUtilItemCallBackSearch : DiffUtil.ItemCallback<CitySearchResponse>() {
    override fun areItemsTheSame(oldItem: CitySearchResponse, newItem: CitySearchResponse): Boolean {
        return oldItem.cityKey  == newItem.cityKey
    }

    override fun areContentsTheSame(oldItem: CitySearchResponse, newItem: CitySearchResponse): Boolean {
        return oldItem == newItem
    }

}