package com.gortmol.pmdmtarea2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.gortmol.pmdmtarea2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Binding object to access views in the layout
    private ActivityMainBinding binding;

    /**
     * Called when the activity is first created.
     * Initializes the layout, toolbar, RecyclerView, and loads the list of persons.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down, this Bundle contains the data it most recently supplied.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enable edge-to-edge display for immersive experience
        EdgeToEdge.enable(this);

        // Inflate the layout using View Binding for efficient view access
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set the toolbar as the ActionBar
        setSupportActionBar(binding.toolbar);

        // Set the LayoutManager for RecyclerView to arrange items in a grid with 2 columns
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Create and populate the list of persons with predefined data
        ArrayList<PersonData> persons = new ArrayList<>();
        persons.add(new PersonData(R.drawable.mario, (String) getText(R.string.mario_name), (String) getText(R.string.mario_description), (String) getText(R.string.mario_abilities)));
        persons.add(new PersonData(R.drawable.luigi, (String) getText(R.string.luigi_name), (String) getText(R.string.luigi_description), (String) getText(R.string.luigi_abilities)));
        persons.add(new PersonData(R.drawable.peach, (String) getText(R.string.peach_name), (String) getText(R.string.peach_description), (String) getText(R.string.peach_abilities)));
        persons.add(new PersonData(R.drawable.toad, (String) getText(R.string.toad_name), (String) getText(R.string.toad_description), (String) getText(R.string.toad_abilities)));

        // Set the adapter to the RecyclerView to bind the list of persons to the UI
        binding.recyclerView.setAdapter(new PersonRecyclerViewAdapter(persons, this));

        // Show a SnackBar notification indicating that the list of persons has been loaded
        snackBarPersonsLoaded();
    }

    /**
     * Initializes the contents of the Activity's standard options menu.
     *
     * @param menu The options menu in which items are placed.
     * @return true to display the menu.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the options menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Handles item selections in the options menu.
     *
     * @param item The menu item that was selected.
     * @return true if the menu item is handled, false otherwise.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle item selection in the options menu
        if (item.getItemId() == R.id.menu_about) {
            // Show the 'About' dialog when the About menu item is selected
            showAboutDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Displays an 'About' dialog with information about the app.
     */
    private void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.menu_about)
                .setMessage(R.string.about_dialog_message)
                .setIcon(R.drawable.super_mario_ia)
                .setPositiveButton(R.string.ok, (dialog, which) -> {
                    // Close the dialog when 'OK' is clicked
                    dialog.dismiss();
                });
        builder.create().show();
    }

    /**
     * Displays a SnackBar with a welcome message when the person list is loaded.
     */
    public void snackBarPersonsLoaded() {
        Snackbar.make(binding.getRoot(), R.string.welcome, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * Handles the event when a person is clicked in the RecyclerView.
     * Starts the PersonDetailsActivity and passes the selected person's data.
     *
     * @param currentPerson The person that was clicked.
     */
    public void personClicked(PersonData currentPerson) {
        // Create an intent to start the PersonDetailsActivity
        Intent intent = new Intent(this, PersonDetailsActivity.class);
        // Pass the selected person's data to the next activity
        intent.putExtra("image", currentPerson.getImage());
        intent.putExtra("name", currentPerson.getName());
        intent.putExtra("description", currentPerson.getDescription());
        intent.putExtra("abilities", currentPerson.getAbilities());
        // Start the PersonDetailsActivity
        startActivity(intent);
    }
}