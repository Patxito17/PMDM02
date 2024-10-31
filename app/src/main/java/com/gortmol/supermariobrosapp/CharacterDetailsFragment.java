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

/**
 * Fragment to display details of a character, including image, name, description, and abilities.
 */
public class CharacterDetailsFragment extends Fragment {

    // View binding for accessing the views in fragment_character_details layout
    private FragmentCharacterDetailsBinding binding;

    /**
     * Inflates the layout for this fragment using View Binding.
     *
     * @param inflater           The LayoutInflater object to inflate views in the fragment.
     * @param container          The parent view that this fragment's UI should be attached to.
     * @param savedInstanceState The saved instance state bundle.
     * @return The root view of the binding.
     */
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Called immediately after onCreateView; sets up the views with data passed through arguments.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState The saved instance state bundle.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Retrieve the data passed as arguments to this fragment
        assert getArguments() != null;
        int image = getArguments().getInt("image");
        String name = getArguments().getString("name");
        String description = getArguments().getString("description");
        String abilities = getArguments().getString("abilities");

        // Populate the views with the character data
        binding.image.setImageResource(image);
        binding.name.setText(name);
        binding.description.setText(description);
        binding.abilities.setText(abilities);

        // Display a Toast message confirming the character details are loaded
        Toast.makeText(getContext(), getString(R.string.toast_details_uploaded_for) + " " + name, Toast.LENGTH_SHORT).show();
    }

    /**
     * Cleans up the binding reference to avoid memory leaks when the view is destroyed.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
