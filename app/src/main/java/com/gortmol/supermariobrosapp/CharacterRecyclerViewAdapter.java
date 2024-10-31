package com.gortmol.supermariobrosapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gortmol.supermariobrosapp.databinding.ItemCardviewBinding;

import java.util.ArrayList;

/**
 * Adapter for the RecyclerView that displays a list of video game characters.
 * Responsible for creating and binding the ViewHolder for each character item.
 */
public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    // List of character data to be displayed
    private final ArrayList<CharacterData> characters;

    // Reference to the HomeFragment to handle character selection
    private final HomeFragment homeFragment;

    /**
     * Constructor for CharacterRecyclerViewAdapter.
     *
     * @param characters   ArrayList of CharacterData objects to be displayed.
     * @param homeFragment Reference to the HomeFragment for handling character selection.
     */
    public CharacterRecyclerViewAdapter(ArrayList<CharacterData> characters, HomeFragment homeFragment) {
        this.characters = characters;
        this.homeFragment = homeFragment;
    }

    /**
     * Creates a new ViewHolder for a character item.
     *
     * @param parent   The ViewGroup into which the new view will be added.
     * @param viewType The view type of the new view.
     * @return A new instance of CharacterViewHolder.
     */
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCardviewBinding binding = ItemCardviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CharacterViewHolder(binding);
    }

    /**
     * Binds data to the ViewHolder, setting up the character item details and click listener.
     *
     * @param holder   The ViewHolder which should be updated.
     * @param position The position of the character item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        CharacterData currentCharacter = characters.get(position);
        holder.bind(currentCharacter);

        // Sets a click listener on the item to handle character selection
        holder.itemView.setOnClickListener(view -> characterSelected(currentCharacter, view));
    }

    /**
     * Handles character selection by calling the characterSelected method in HomeFragment.
     *
     * @param currentCharacter The character that was selected.
     * @param view             The view representing the selected character item.
     */
    private void characterSelected(CharacterData currentCharacter, View view) {
        homeFragment.characterSelected(currentCharacter, view);
    }

    /**
     * Returns the total number of characters in the list.
     *
     * @return The number of character items.
     */
    @Override
    public int getItemCount() {
        return characters.size();
    }
}