package com.gortmol.supermariobrosapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gortmol.supermariobrosapp.databinding.ItemCardviewBinding;

/**
 * ViewHolder for the character items in the RecyclerView.
 * Manages the data binding for each character item view.
 */
public class CharacterViewHolder extends RecyclerView.ViewHolder {

    // Binding object for accessing and modifying the item view's components
    private final ItemCardviewBinding binding;

    /**
     * Constructor for CharacterViewHolder.
     *
     * @param binding The ItemCardviewBinding instance for accessing the layout's views.
     */
    public CharacterViewHolder(@NonNull ItemCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Binds the character data to the view components.
     *
     * @param character The CharacterData object containing the character's details.
     */
    public void bind(CharacterData character) {
        // Set the character's image resource to the ImageView
        binding.characterImage.setImageResource(character.getImage());

        // Set the character's name to the TextView
        binding.characterName.setText(character.getName());

        // Execute any pending bindings to apply data changes immediately
        binding.executePendingBindings();
    }
}