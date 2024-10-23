package com.gortmol.pmdmtarea2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.gortmol.pmdmtarea2.databinding.ActivityPersonDetailsBinding;

public class PersonDetailsActivity extends AppCompatActivity {

    private ActivityPersonDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Inflate the Layout using View Binding
        binding = ActivityPersonDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get the intent
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