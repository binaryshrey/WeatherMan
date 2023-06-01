package dev.shreyansh.weatherman.ui

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dev.shreyansh.weatherman.R
import dev.shreyansh.weatherman.databinding.FragmentSearchBinding
import dev.shreyansh.weatherman.network.response.CitySearchResponse
import dev.shreyansh.weatherman.utils.CurrentLocation
import dev.shreyansh.weatherman.utils.SearchRecyclerAdapter
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
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = weatherManViewModel

        binding.searchEditText.postDelayed(Runnable { showSoftKeyboard(binding.searchEditText)} , 50)

        val searchRecyclerAdapter: SearchRecyclerAdapter = SearchRecyclerAdapter(
            SearchRecyclerAdapter.OnClickListener {loadWeatherForSelectedCity(it)
        })

        binding.searchRV.adapter = searchRecyclerAdapter
        weatherManViewModel.citySearchResults.observe(viewLifecycleOwner, Observer {
            it?.let { searchRecyclerAdapter.submitList(it.toMutableList()) }
        })


        binding.search.setOnClickListener {
            search()
        }

        binding.searchToolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.searchEditText.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                search()
                true
            } else {
                false
            }
        }

        return binding.root
    }

    private fun loadWeatherForSelectedCity(citySearchResponse: CitySearchResponse) {
        val location : CurrentLocation = CurrentLocation(citySearchResponse.city,citySearchResponse.country.ID)
        weatherManViewModel.updateCurrentLocation(location)
        findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToHomeFragment(location))

    }

    private fun search(){
        if(binding.searchEditText.text.toString().isNullOrEmpty()){
            Toast.makeText(context,"Query Too Short",Toast.LENGTH_SHORT).show()
        }

        else if(binding.searchEditText.text.toString().length > 20){
            Toast.makeText(context,"Query Too Long",Toast.LENGTH_SHORT).show()
        }
        else{
            weatherManViewModel.getSearchedCity(binding.searchEditText.text.toString())
            binding.searchEditText.postDelayed(Runnable { hideSoftKeyboard(binding.searchEditText)} , 50)

        }
    }

    private fun showSoftKeyboard(view: View) {
        val inputMethodManager: InputMethodManager = requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        view.requestFocus()
        inputMethodManager.showSoftInput(view, 0)
    }

    private fun hideSoftKeyboard(view: View) {
        val inputMethodManager: InputMethodManager = requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }



}