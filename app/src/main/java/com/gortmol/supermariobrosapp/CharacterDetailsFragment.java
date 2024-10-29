package com.gortmol.supermariobrosapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gortmol.supermariobrosapp.databinding.FragmentCharacterDetailsBinding;

public class CharacterDetailsFragment extends Fragment {

    private FragmentCharacterDetailsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get the data from the intent
        assert getArguments() != null;
        int image = getArguments().getInt("image");
        String name = getArguments().getString("name");
        String description = getArguments().getString("description");
        String abilities = getArguments().getString("abilities");

        // Set the data to the views
        binding.image.setImageResource(image);
        binding.name.setText(name);
        binding.description.setText(description);
        binding.abilities.setText(abilities);


        // Displays a Toast with the message "Details loaded for <character name>"
        Toast.makeText(getContext(), getString(R.string.toast_details_uploaded_for) + " " + name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}