package dev.shreyansh.weatherman.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.shreyansh.weatherman.databinding.DailyForecastListItemBinding
import dev.shreyansh.weatherman.network.response.ForecastResponse
import dev.shreyansh.weatherman.network.response.HourlyForecastResponse


class DailyForecastRecyclerAdapter( val onClickListener: OnClickListener) : ListAdapter<ForecastResponse, DailyForecastRecyclerAdapter.ViewHolder>(DiffUtilItemCallBackDailyForecast()) {


    class ViewHolder private constructor(val binding : DailyForecastListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ForecastResponse) {
            binding.daily = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = DailyForecastListItemBinding.inflate(layoutInflater, parent, false)
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

    class OnClickListener(val clickListener: (daily: ForecastResponse) -> Unit) {
        fun onClick(daily: ForecastResponse) = clickListener(daily)
    }

}


class DiffUtilItemCallBackDailyForecast : DiffUtil.ItemCallback<ForecastResponse>() {
    override fun areItemsTheSame(oldItem: ForecastResponse, newItem: ForecastResponse): Boolean {
        return oldItem.date  == newItem.date
    }

    override fun areContentsTheSame(oldItem: ForecastResponse, newItem: ForecastResponse): Boolean {
        return oldItem == newItem
    }

}