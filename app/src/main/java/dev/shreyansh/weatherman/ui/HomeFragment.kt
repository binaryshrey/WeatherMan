package dev.shreyansh.weatherman.ui

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import dev.shreyansh.weatherman.R
import dev.shreyansh.weatherman.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        val cityLocation = HomeFragmentArgs.fromBundle(requireArguments()).location

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        binding.locationTV.text = cityLocation.toString()
        return binding.root
    }


}