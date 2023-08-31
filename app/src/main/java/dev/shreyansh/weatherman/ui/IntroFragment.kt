package dev.shreyansh.weatherman.ui

import android.Manifest
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.tasks.Task
import dev.shreyansh.weatherman.R
import dev.shreyansh.weatherman.databinding.FragmentIntroBinding
import dev.shreyansh.weatherman.utils.CurrentLocation
import dev.shreyansh.weatherman.viewModel.WeatherManViewModel
import dev.shreyansh.weatherman.viewModel.WeatherManViewModelFactory
import java.util.*


class IntroFragment : Fragment() {

    private val REQUEST_LOCATION_PERMISSION = 123

    private lateinit var binding : FragmentIntroBinding
    private lateinit var settingsClient: SettingsClient
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val weatherManViewModel: WeatherManViewModel by activityViewModels {
        WeatherManViewModelFactory(requireNotNull(this.activity).application)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        settingsClient = LocationServices.getSettingsClient(requireActivity())
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_intro, container, false)
        binding.lifecycleOwner = viewLifecycleOwner


        binding.privacyTV.setOnClickListener {
            Toast.makeText(context,"Privacy Policy",Toast.LENGTH_SHORT).show()
        }
        binding.termsTV.setOnClickListener {
            Toast.makeText(context,"Terms of Service",Toast.LENGTH_SHORT).show()
        }


        binding.getStartedButton.setOnClickListener {
            weatherManViewModel.userLocation.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                if(it != ""){
                    val city = it.split(",")[0]
                    val countryCode = it.split(",")[1]
                    weatherManViewModel.getCurrentWeather(city)
                    findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToHomeFragment(CurrentLocation(city,countryCode)))
                }else{
                    checkLocationSettings()
                }
            })
        }

        return binding.root
    }




    private fun checkLocationSettings() {
        val locationRequest = LocationRequest.create()
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
            .setInterval(1000) // Update interval in milliseconds

        val builder = LocationSettingsRequest.Builder().addLocationRequest(locationRequest)
        val settingsTask: Task<LocationSettingsResponse> = settingsClient.checkLocationSettings(builder.build())
        settingsTask.addOnSuccessListener {
            getLastKnownLocation()
        }

        settingsTask.addOnFailureListener { exception ->
            if (exception is ResolvableApiException) {
                try {
                    // Show the user a dialog to enable location settings
                    Toast.makeText(context,"To continue, enable location permission from settings",Toast.LENGTH_SHORT).show()
                    exception.startResolutionForResult(requireActivity(), REQUEST_LOCATION_PERMISSION)
                } catch (sendEx: IntentSender.SendIntentException) {
                    Log.e("LocationSettings","${sendEx.message.toString()}")
                }
            } else {
                Log.e("LocationSettings","${exception.message.toString()}")
            }
        }
    }




    private fun getLastKnownLocation() {
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION_PERMISSION)
        }
        else{
            fusedLocationClient.lastLocation.addOnCompleteListener { task ->
                if (task.isSuccessful && task.result != null) {
                    val location: Location = task.result
                    val currentLocation = getCurrentCity(location.latitude, location.longitude)
                    weatherManViewModel.updateCurrentLocation(currentLocation)
                    weatherManViewModel.getCurrentWeather(currentLocation.city)
                    findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToHomeFragment(currentLocation))
                }
            }
                .addOnFailureListener { task ->
                Log.i("fusedLocationClient","${task.message.toString()}")
            }
        }
    }




    private fun getCurrentCity(latitude: Double, longitude: Double): CurrentLocation {
        val geocoder = Geocoder(requireContext(), Locale.getDefault())
        val addresses: MutableList<Address>? = geocoder.getFromLocation(latitude, longitude, 1)

        if (addresses != null) {
            if (addresses.isNotEmpty()) {
                val address: Address = addresses[0]
                return CurrentLocation(address.locality,address.countryCode)
            }
        }

        return CurrentLocation()
    }








    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playVideo()
    }

    private fun playVideo() {
        val videoPath = "android.resource://${requireActivity().packageName}/${R.raw.weather_bg}"
        val videoUri = Uri.parse(videoPath)
        binding.videoView.setVideoURI(videoUri)
        binding.videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true
            mediaPlayer.start()
        }
    }

}