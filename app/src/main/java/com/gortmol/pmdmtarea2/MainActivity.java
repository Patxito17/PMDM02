package com.gortmol.pmdmtarea2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import com.gortmol.pmdmtarea2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Inflate the Layout using View Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Define the LayoutManager
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Person list
        ArrayList<PersonData> persons = new ArrayList<>();
        persons.add(new PersonData(R.drawable.mario, (String) getText(R.string.mario_name), (String) getText(R.string.mario_description), (String) getText(R.string.mario_abilities)));
        persons.add(new PersonData(R.drawable.luigi, (String) getText(R.string.luigi_name), (String) getText(R.string.luigi_description), (String) getText(R.string.luigi_abilities)));
        persons.add(new PersonData(R.drawable.peach, (String) getText(R.string.peach_name), (String) getText(R.string.peach_description), (String) getText(R.string.peach_abilities)));
        persons.add(new PersonData(R.drawable.toad, (String) getText(R.string.toad_name), (String) getText(R.string.toad_description), (String) getText(R.string.toad_abilities)));

        binding.recyclerView.setAdapter(new PersonRecyclerViewAdapter(persons, this));

    }

    public void personClicked(PersonData currentPerson) {
        Intent intent = new Intent(this, PersonDetailsActivity.class);
        intent.putExtra("image", currentPerson.getImage());
        intent.putExtra("name", currentPerson.getName());
        intent.putExtra("description", currentPerson.getDescription());
        intent.putExtra("abilities", currentPerson.getAbilities());
        startActivity(intent);
    }
}