package dev.shreyansh.weatherman.ui

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dev.shreyansh.weatherman.R
import dev.shreyansh.weatherman.databinding.FragmentIntroBinding


class IntroFragment : Fragment() {

    private lateinit var binding : FragmentIntroBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            requireActivity().window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }


        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_intro, container, false)
        return binding.root
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