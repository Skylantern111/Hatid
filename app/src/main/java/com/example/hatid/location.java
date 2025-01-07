package com.example.hatid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class location extends AppCompatActivity {
    private TextView addhome, addschool, addwork, addother;
    private EditText pickupInput, dropoffInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_location); // Make sure this layout is correct

        // Initialize views
        addhome = findViewById(R.id.addhome);
        addschool = findViewById(R.id.addschool);
        addwork = findViewById(R.id.addwork);
        addother = findViewById(R.id.addother);
        pickupInput = findViewById(R.id.PickupInput);
        dropoffInput = findViewById(R.id.dropoffInput);

        // Check if views are not null
        if (addhome == null || addschool == null || addwork == null || addother == null) {
            throw new NullPointerException("Some views are null!");
        }

        // Set up click listeners for location selection
        addhome.setOnClickListener(view -> openLoc2("Home"));
        addschool.setOnClickListener(view -> openLoc2("School"));
        addwork.setOnClickListener(view -> openLoc2("Work"));
        addother.setOnClickListener(view -> openLoc2("Another Place"));

        // Get the identifier passed from HomeActivity to adjust the EditText background color
        String editTextId = getIntent().getStringExtra("EDIT_TEXT_ID");

 
    }

    // Helper method to handle intent for location selection
    private void openLoc2(String addressType) {
        Intent intent = new Intent(location.this, loc2.class);
        intent.putExtra("ADDRESS_TYPE", addressType); // Pass address type to next activity
        startActivity(intent);
    }
}
