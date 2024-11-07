package com.example.m3lesson2_hw;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m3lesson2_hw.Game.*;
import com.example.m3lesson2_hw.databinding.FragmentBlankFirstBinding;


public class StartGameFragment extends Fragment {

    FragmentBlankFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBlankFirstBinding.inflate(getLayoutInflater());

        binding.startButton.setOnClickListener(v -> startGame());


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void startGame() {
        Logic.resetGame();
        Logic.startGame();
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_view, new StatsGameFragment())
                .addToBackStack(null)
                .commit();
    }
}