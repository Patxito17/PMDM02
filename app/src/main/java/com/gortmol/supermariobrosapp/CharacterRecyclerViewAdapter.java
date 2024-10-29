package com.gortmol.supermariobrosapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gortmol.supermariobrosapp.databinding.ItemCardviewBinding;

import java.util.ArrayList;

public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    private final ArrayList<CharacterData> characters;
    private final HomeFragment homeFragment;

    public CharacterRecyclerViewAdapter(ArrayList<CharacterData> persons, HomeFragment homeFragment) {
        this.characters = persons;
        this.homeFragment = homeFragment;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCardviewBinding binding = ItemCardviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CharacterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        CharacterData currentCharacter = characters.get(position);
        holder.bind(currentCharacter);

        holder.itemView.setOnClickListener(view -> characterSelected(currentCharacter, view));

    }

    private void characterSelected(CharacterData currentCharacter, View view) {
        homeFragment.characterSelected(currentCharacter, view);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}
