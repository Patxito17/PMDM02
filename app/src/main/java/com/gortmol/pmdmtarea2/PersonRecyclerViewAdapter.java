package com.gortmol.pmdmtarea2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gortmol.pmdmtarea2.databinding.PersonItemCardviewBinding;

import java.util.ArrayList;

public class PersonRecyclerViewAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private final ArrayList<PersonData> persons;
    private final Context context;

    public PersonRecyclerViewAdapter(ArrayList<PersonData> persons, Context context) {
        this.persons = persons;
        this.context = context;
    }

    // Create the ViewHolder
    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PersonItemCardviewBinding binding = PersonItemCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new PersonViewHolder(binding);
    }

    // Bind data to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        PersonData currentPerson = this.persons.get(position);
        holder.bind(currentPerson);

        // Set event
        holder.itemView.setOnClickListener(view -> personClicked(currentPerson));
    }

    private void personClicked(PersonData currentPerson) {
        ((MainActivity) context).personClicked(currentPerson);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
