package com.example.birdify.ui.Sightings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.birdify.databinding.FragmentSightingsBinding;

public class SightingsFragment extends Fragment {

    private FragmentSightingsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SightingsViewModel sightingsViewModel =
                new ViewModelProvider(this).get(SightingsViewModel.class);

        binding = FragmentSightingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}