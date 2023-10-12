package com.example.birdify.ui.Hotspot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HotspotViewModel : ViewModel() {
    private val mText: MutableLiveData<String>

    init {
        mText = MutableLiveData()
        mText.value = "This is Hotspot fragment"
    }

    val text: LiveData<String>
        get() = mText
}