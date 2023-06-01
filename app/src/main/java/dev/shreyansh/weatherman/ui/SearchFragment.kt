package dev.shreyansh.weatherman.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import dev.shreyansh.weatherman.R
import dev.shreyansh.weatherman.databinding.FragmentSearchBinding
import dev.shreyansh.weatherman.viewModel.WeatherManViewModel
import dev.shreyansh.weatherman.viewModel.WeatherManViewModelFactory


class SearchFragment : Fragment() {

    private lateinit var binding : FragmentSearchBinding
    private val weatherManViewModel: WeatherManViewModel by activityViewModels {
        WeatherManViewModelFactory(requireNotNull(this.activity).application)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search, container, false)

        binding.searchIV.setOnClickListener {
            if(binding.searchEditText.text.toString().isNullOrEmpty()){
                Toast.makeText(context,"Query Too Short",Toast.LENGTH_SHORT).show()
            }

            else if(binding.searchEditText.text.toString().length > 20){
                Toast.makeText(context,"Query Too Long",Toast.LENGTH_SHORT).show()
            }
            else{
                weatherManViewModel.getSearchedCity(binding.searchEditText.text.toString())
            }
        }

        return binding.root
    }


}