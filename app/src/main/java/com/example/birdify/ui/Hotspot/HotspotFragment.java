package com.example.birdify.ui.Hotspot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.birdify.databinding.FragmentHotspotBinding;

public class HotspotFragment extends Fragment {

    private FragmentHotspotBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HotspotViewModel dashboardViewModel =
                new ViewModelProvider(this).get(HotspotViewModel.class);

        binding = FragmentHotspotBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}