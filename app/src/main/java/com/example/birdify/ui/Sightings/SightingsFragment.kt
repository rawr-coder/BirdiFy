package com.example.birdify.ui.Sightings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.birdify.databinding.FragmentSightingsBinding

class SightingsFragment : Fragment() {
    private var binding: FragmentSightingsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val sightingsViewModel =
            ViewModelProvider(this).get(
                SightingsViewModel::class.java
            )
        binding = FragmentSightingsBinding.inflate(
            inflater,
            container,
            false
        )
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}