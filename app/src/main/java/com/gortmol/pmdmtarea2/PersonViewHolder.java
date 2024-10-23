package com.gortmol.pmdmtarea2;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gortmol.pmdmtarea2.databinding.PersonItemCardviewBinding;

public class PersonViewHolder extends RecyclerView.ViewHolder {

    PersonItemCardviewBinding binding;

    public PersonViewHolder(@NonNull PersonItemCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(PersonData person) {
        binding.image.setImageResource(person.getImage());
        binding.personName.setText(person.getName());
        binding.executePendingBindings();
    }
}
