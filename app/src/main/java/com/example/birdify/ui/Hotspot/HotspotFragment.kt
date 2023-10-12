package com.example.birdify.ui.Hotspot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.birdify.databinding.FragmentHotspotBinding

class HotspotFragment : Fragment() {
    private var binding: FragmentHotspotBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val dashboardViewModel = ViewModelProvider(this).get(
            HotspotViewModel::class.java
        )
        binding = FragmentHotspotBinding.inflate(
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