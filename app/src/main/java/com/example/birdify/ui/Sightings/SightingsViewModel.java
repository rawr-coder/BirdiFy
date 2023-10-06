package com.example.birdify.ui.Sightings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SightingsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SightingsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Sightings fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}