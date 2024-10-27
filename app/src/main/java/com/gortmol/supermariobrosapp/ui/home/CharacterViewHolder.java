package com.gortmol.supermariobrosapp.ui.home;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gortmol.supermariobrosapp.CharacterData;
import com.gortmol.supermariobrosapp.databinding.ItemCardviewBinding;

public class CharacterViewHolder extends RecyclerView.ViewHolder{

    private final ItemCardviewBinding binding;

    public CharacterViewHolder(@NonNull ItemCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(CharacterData person) {
    binding.characterImage.setImageResource(person.getImage());
    binding.characterName.setText(person.getName());
    binding.executePendingBindings();
    }
}
