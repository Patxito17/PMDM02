package com.gortmol.pmdmtarea2;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gortmol.pmdmtarea2.databinding.PersonItemCardviewBinding;

/**
 * ViewHolder class for holding character data views in the RecyclerView.
 */
public class PersonViewHolder extends RecyclerView.ViewHolder {

    // Binding object to access views in the character item layout
    PersonItemCardviewBinding binding;

    /**
     * Constructor for the PersonViewHolder.
     *
     * @param binding The binding object that connects the layout views to the ViewHolder.
     */
    public PersonViewHolder(@NonNull PersonItemCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Binds character data to the views.
     *
     * @param person The character data to bind to the views.
     */
    public void bind(PersonData person) {
        binding.image.setImageResource(person.getImage());
        binding.personName.setText(person.getName());
        binding.executePendingBindings();
    }
}