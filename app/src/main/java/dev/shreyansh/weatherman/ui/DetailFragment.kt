package dev.shreyansh.weatherman.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dev.shreyansh.weatherman.R
import dev.shreyansh.weatherman.databinding.FragmentDetailBinding
import dev.shreyansh.weatherman.utils.HourlyForecastRecyclerAdapter
import dev.shreyansh.weatherman.utils.convertTo12HourFormat
import dev.shreyansh.weatherman.utils.formatMillisToDayDate
import dev.shreyansh.weatherman.viewModel.WeatherManViewModel
import dev.shreyansh.weatherman.viewModel.WeatherManViewModelFactory


class DetailFragment : Fragment() {

    private lateinit var binding : FragmentDetailBinding
    private val weatherManViewModel: WeatherManViewModel by activityViewModels {
        WeatherManViewModelFactory(requireNotNull(this.activity).application)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false)

        val currentLocation = HomeFragmentArgs.fromBundle(requireArguments()).currentLocation
        binding.locTV.text = "${currentLocation.city}, ${currentLocation.countryCode}"
        binding.dateTV.text = formatMillisToDayDate(System.currentTimeMillis()).toString()
        binding.lastUpdated.text = "Last Updated : ${convertTo12HourFormat(System.currentTimeMillis()).toString()}"
        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = weatherManViewModel

        val hourlyForecastRecyclerAdapter: HourlyForecastRecyclerAdapter = HourlyForecastRecyclerAdapter(
            HourlyForecastRecyclerAdapter.OnClickListener {navigateToHourlyWeb(it.weatherURI)
        },requireActivity())


        binding.hourlyForecastRV.adapter = hourlyForecastRecyclerAdapter
        weatherManViewModel.hourlyForecast.observe(viewLifecycleOwner, Observer {
            it?.let { hourlyForecastRecyclerAdapter.submitList(it.toMutableList()) }
        })

        binding.backIV.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

    private fun navigateToHourlyWeb(weatherURI: String) {
        val navigateIntent = Intent(Intent.ACTION_VIEW)
        navigateIntent.data = Uri.parse(weatherURI)
        startActivity(navigateIntent)
    }


}