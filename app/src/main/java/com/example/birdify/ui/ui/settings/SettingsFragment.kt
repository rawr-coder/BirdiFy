package com.example.birdify.ui.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.birdify.R
import com.example.birdify.databinding.FragmentSettingsBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database

class SettingsFragment : Fragment() {
    private var binding: FragmentSettingsBinding? = null
    private lateinit var radioMetric: RadioButton
    private lateinit var distanceSeekBar: SeekBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val settingsViewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize your views
        radioMetric = view.findViewById(R.id.radio_metric)
        distanceSeekBar = view.findViewById(R.id.distanceSeekBar)

        // Set a click listener for the "Save" button
        view.findViewById<Button>(R.id.SignIn).setOnClickListener {
            // Get the selected radio button (Metric or Imperial)
            val useMetricSystem = radioMetric.isChecked

            // Get the SeekBar progress for max distance
            val maxDistance = distanceSeekBar.progress

            // Save user settings to Firebase here
            saveUserSettings(useMetricSystem, maxDistance)
        }
    }

    private fun saveUserSettings(useMetricSystem: Boolean, maxDistance: Int) {
        // Save the user's settings to Firebase Realtime Database

        val user = FirebaseAuth.getInstance().currentUser
        val userId = user?.uid
        if (userId != null) {
            val databaseReference: DatabaseReference =
                FirebaseDatabase.getInstance().reference.child("users").child(userId)

            // Create a UserSettings object
            val userSettings = UserSettings(useMetricSystem, maxDistance)

            // Save the user's settings to the database
            databaseReference.setValue(userSettings)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
data class UserSettings(val useMetricSystem: Boolean, val maxDistance: Int)
