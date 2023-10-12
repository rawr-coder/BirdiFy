package com.example.birdify.ui.Sightings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SightingsViewModel : ViewModel() {
    private val mText: MutableLiveData<String>

    init {
        mText = MutableLiveData()
        mText.value = "This is Sightings fragment"
    }

    val text: LiveData<String>
        get() = mText
}