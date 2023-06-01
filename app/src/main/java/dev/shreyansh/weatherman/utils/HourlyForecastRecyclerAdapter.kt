package dev.shreyansh.weatherman.utils

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.shreyansh.weatherman.databinding.HourlyForecastListItemBinding
import dev.shreyansh.weatherman.network.response.HourlyForecastResponse


class HourlyForecastRecyclerAdapter( val onClickListener: OnClickListener, private val activity: Activity) : ListAdapter<HourlyForecastResponse, HourlyForecastRecyclerAdapter.ViewHolder>(DiffUtilItemCallBackHourlyForecast()) {


    class ViewHolder private constructor(val binding : HourlyForecastListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HourlyForecastResponse) {
            binding.hourly = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = HourlyForecastListItemBinding.inflate(layoutInflater, parent, false)
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

    class OnClickListener(val clickListener: (hourly: HourlyForecastResponse) -> Unit) {
        fun onClick(hourly: HourlyForecastResponse) = clickListener(hourly)
    }

}


class DiffUtilItemCallBackHourlyForecast : DiffUtil.ItemCallback<HourlyForecastResponse>() {
    override fun areItemsTheSame(oldItem: HourlyForecastResponse, newItem: HourlyForecastResponse): Boolean {
        return oldItem.dateTime  == newItem.dateTime
    }

    override fun areContentsTheSame(oldItem: HourlyForecastResponse, newItem: HourlyForecastResponse): Boolean {
        return oldItem == newItem
    }

}