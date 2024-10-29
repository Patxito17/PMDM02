package com.gortmol.supermariobrosapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import com.gortmol.supermariobrosapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<CharacterData> characterList;
    private CharacterRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Create and populate the list of characters with predefined data
        loadCharacters();

        adapter = new CharacterRecyclerViewAdapter(characterList, this);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        binding.recyclerView.setAdapter(adapter);

    }

    private void loadCharacters() {
        characterList = new ArrayList<>();
        characterList.add(new CharacterData(R.drawable.mario, (String) getText(R.string.mario_name), (String) getText(R.string.mario_description), (String) getText(R.string.mario_abilities)));
        characterList.add(new CharacterData(R.drawable.luigi, (String) getText(R.string.luigi_name), (String) getText(R.string.luigi_description), (String) getText(R.string.luigi_abilities)));
        characterList.add(new CharacterData(R.drawable.peach, (String) getText(R.string.peach_name), (String) getText(R.string.peach_description), (String) getText(R.string.peach_abilities)));
        characterList.add(new CharacterData(R.drawable.toad, (String) getText(R.string.toad_name), (String) getText(R.string.toad_description), (String) getText(R.string.toad_abilities)));
        characterList.add(new CharacterData(R.drawable.yoshi, (String) getText(R.string.yoshi_name), (String) getText(R.string.yoshi_description), (String) getText(R.string.yoshi_abilities)));
        characterList.add(new CharacterData(R.drawable.bowser, (String) getText(R.string.bowser_name), (String) getText(R.string.bowser_description), (String) getText(R.string.bowser_abilities)));
        characterList.add(new CharacterData(R.drawable.wario, (String) getText(R.string.wario_name), (String) getText(R.string.wario_description), (String) getText(R.string.wario_abilities)));
        characterList.add(new CharacterData(R.drawable.donkey_kong, (String) getText(R.string.donkey_kong_name), (String) getText(R.string.donkey_kong_description), (String) getText(R.string.donkey_kong_abilities)));
        characterList.add(new CharacterData(R.drawable.daisy, (String) getText(R.string.daisy_name), (String) getText(R.string.daisy_description), (String) getText(R.string.daisy_abilities)));
        characterList.add(new CharacterData(R.drawable.rosalina, (String) getText(R.string.rosalina_name), (String) getText(R.string.rosalina_description), (String) getText(R.string.rosalina_abilities)));
        characterList.add(new CharacterData(R.drawable.toadette, (String) getText(R.string.toadette_name), (String) getText(R.string.toadette_description), (String) getText(R.string.toadette_abilities)));
        characterList.add(new CharacterData(R.drawable.bowser_jr, (String) getText(R.string.bowser_jr_name), (String) getText(R.string.bowser_jr_description), (String) getText(R.string.bowser_jr_abilities)));
    }

    public void characterSelected(CharacterData currentCharacter, View view) {
        // Create an intent to start the PersonDetailsActivity
        Intent intent = new Intent(this.getContext(), CharacterDetailsFragment.class);
        // Pass the selected character's data to the next activity
        intent.putExtra("image", currentCharacter.getImage());
        intent.putExtra("name", currentCharacter.getName());
        intent.putExtra("description", currentCharacter.getDescription());
        intent.putExtra("abilities", currentCharacter.getAbilities());
        // Start the CharacterDetailsFragment
        Navigation.findNavController(view).navigate(R.id.nav_characterDetails, intent.getExtras());

    }
}