package dev.shreyansh.weatherman.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import dev.shreyansh.weatherman.R
import dev.shreyansh.weatherman.databinding.FragmentHomeBinding
import dev.shreyansh.weatherman.network.response.HourlyForecastResponse
import dev.shreyansh.weatherman.utils.DailyForecastRecyclerAdapter
import dev.shreyansh.weatherman.utils.HourlyForecastRecyclerAdapter
import dev.shreyansh.weatherman.utils.convertTo12HourFormat
import dev.shreyansh.weatherman.utils.formatMillisToDayDate
import dev.shreyansh.weatherman.viewModel.WeatherManViewModel
import dev.shreyansh.weatherman.viewModel.WeatherManViewModelFactory


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val weatherManViewModel: WeatherManViewModel by activityViewModels {
        WeatherManViewModelFactory(requireNotNull(this.activity).application)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        val currentLocation = HomeFragmentArgs.fromBundle(requireArguments()).currentLocation

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        binding.locationTV.text = "${currentLocation.city}, ${currentLocation.countryCode}"
        binding.dateTV.text = formatMillisToDayDate(System.currentTimeMillis()).toString()
        binding.timeTV.text = convertTo12HourFormat(System.currentTimeMillis()).toString()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = weatherManViewModel


        val hourlyForecastRecyclerAdapter: HourlyForecastRecyclerAdapter = HourlyForecastRecyclerAdapter(HourlyForecastRecyclerAdapter.OnClickListener {navigateToHourlyWeb(it)
        },requireActivity())

        val dailyForecastRecyclerAdapter: DailyForecastRecyclerAdapter = DailyForecastRecyclerAdapter()


        binding.hourlyForecastRV.adapter = hourlyForecastRecyclerAdapter
        binding.dailyForecastRV.adapter = dailyForecastRecyclerAdapter

        weatherManViewModel.hourlyForecast.observe(viewLifecycleOwner, Observer {
            it?.let { hourlyForecastRecyclerAdapter.submitList(it.toMutableList()) }
        })

        weatherManViewModel.dailyForecast.observe(viewLifecycleOwner, Observer {
            it?.let { dailyForecastRecyclerAdapter.submitList(it.dailyForecasts.toMutableList()) }
        })



        return binding.root
    }

    private fun navigateToHourlyWeb(it: HourlyForecastResponse) {
        val navigateIntent = Intent(Intent.ACTION_VIEW)
        navigateIntent.data = Uri.parse(it.weatherURI)
        startActivity(navigateIntent)
    }


}