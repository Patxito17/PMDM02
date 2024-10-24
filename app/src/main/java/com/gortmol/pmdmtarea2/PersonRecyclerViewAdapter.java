package com.gortmol.pmdmtarea2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gortmol.pmdmtarea2.databinding.PersonItemCardviewBinding;

import java.util.ArrayList;

/**
 * Adapter class for binding character data to a RecyclerView.
 */
public class PersonRecyclerViewAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    // List of character data to be displayed
    private final ArrayList<PersonData> persons;

    // Context of the activity using this adapter
    private final Context context;

    /**
     * Constructor for the PersonRecyclerViewAdapter.
     *
     * @param persons The list of characters to display.
     * @param context The context in which the adapter is used.
     */
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

        // Set event listener for item clicks
        holder.itemView.setOnClickListener(view -> personClicked(currentPerson));
    }

    /**
     * Handle the click event for a character item.
     *
     * @param currentPerson The character that was clicked.
     */
    private void personClicked(PersonData currentPerson) {
        // Notify the MainActivity that a character was clicked
        ((MainActivity) context).personClicked(currentPerson);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}