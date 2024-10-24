package com.gortmol.pmdmtarea2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.gortmol.pmdmtarea2.databinding.ActivityPersonDetailsBinding;

public class PersonDetailsActivity extends AppCompatActivity {

    // Binding object to access views in the layout
    private ActivityPersonDetailsBinding binding;

    /**
     * Called when the activity is first created.
     * Initializes the layout and sets character details from the intent.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down, this Bundle contains the data it most recently supplied.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enable edge-to-edge display for immersive experience
        EdgeToEdge.enable(this);

        // Inflate the layout using View Binding for efficient view access
        binding = ActivityPersonDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get the intent that started this activity
        Bundle extras = getIntent().getExtras();

        // Get the data from the intent
        assert extras != null;
        int image = extras.getInt("image");
        String name = extras.getString("name");
        String description = extras.getString("description");
        String abilities = extras.getString("abilities");

        // Set the data to the views
        binding.image.setImageResource(image);
        binding.name.setText(name);
        binding.description.setText(description);
        binding.abilities.setText(abilities);

        // Displays a Toast with the message "Details loaded for <character name>"
        Toast.makeText(this, getString(R.string.toast_details_uploaded_for) + " " + name, Toast.LENGTH_SHORT).show();
    }
}