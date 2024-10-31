package com.gortmol.supermariobrosapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.gortmol.supermariobrosapp.databinding.ActivityMainBinding;

/**
 * Main activity of the application that manages the navigation drawer and toolbar.
 */
public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;  // Configuration for handling navigation actions
    private ActivityMainBinding binding;  // Binding instance for accessing layout views

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down, this contains the data most recently supplied in onSaveInstanceState.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set up the toolbar
        setSupportActionBar(binding.appBarMain.toolbar);

        // Set up the navigation drawer
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Configure the top-level destinations for the navigation
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_settings)  // Define top-level destinations
                .setOpenableLayout(drawer)  // Set drawer as the openable layout
                .build();

        // Initialize NavController for managing navigation actions
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        // Set up the action bar with NavController
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        // Connect navigation view to the navigation controller
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    /**
     * Inflate the options menu for the app bar.
     *
     * @param menu The options menu in which you place items.
     * @return true to display the menu; false if not shown.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.main, menu);
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
        // Check if the selected menu item is "About"
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
        // Create an AlertDialog builder for the 'About' dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.menu_about)  // Set dialog title
                .setMessage(R.string.about_dialog_message)  // Set dialog message
                .setIcon(R.drawable.logo_app)  // Set dialog icon
                .setPositiveButton(R.string.ok, (dialog, which) -> {
                    // Close the dialog when 'OK' is clicked
                    dialog.dismiss();
                });

        // Show the 'About' dialog
        builder.create().show();
    }

    /**
     * Handles the "Up" navigation action.
     *
     * @return true if navigation was successful, false otherwise.
     */
    @Override
    public boolean onSupportNavigateUp() {
        // Retrieve NavController and perform navigation up action
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }
}
