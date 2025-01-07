package com.example.hatid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class loc2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_loc2); // Make sure your layout is correctly referenced

        // Find the TextView by its ID
        TextView name = findViewById(R.id.Name);

        // Get the data passed from the previous activity (address type)
        String addressType = getIntent().getStringExtra("ADDRESS_TYPE");

        // Set the address type to the Name TextView
        if (addressType != null) {
            name.setText(addressType);
        }
    }
}
