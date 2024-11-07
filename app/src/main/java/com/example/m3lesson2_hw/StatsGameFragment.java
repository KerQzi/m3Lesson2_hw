package com.example.m3lesson2_hw;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m3lesson2_hw.Game.*;
import com.example.m3lesson2_hw.databinding.FragmentStatsGameBinding;


public class StatsGameFragment extends Fragment {

    FragmentStatsGameBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentStatsGameBinding.inflate(getLayoutInflater());

        updateStatistics();
        binding.backButton.setOnClickListener(v -> onDestroyView());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public void updateStatistics() {
        String stats = Logic.getStatistics();
        binding.statsTextView.setText(stats);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        requireActivity().getSupportFragmentManager().popBackStack();
    }
}