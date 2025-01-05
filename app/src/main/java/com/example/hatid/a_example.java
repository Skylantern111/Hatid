package com.example.hatid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class a_example extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_example);

        // Initialize views
        ImageView backArrow = findViewById(R.id.backArrow);
        Button aboutButton = findViewById(R.id.a_about);
        Button complainButton = findViewById(R.id.a_complain);
        Button helpButton = findViewById(R.id.a_helpnsupport);
        Button profileButton = findViewById(R.id.Profile);
        Button setPassButton = findViewById(R.id.setpass);

        // Back Arrow Click Listener
        backArrow.setOnClickListener(v -> {
            finish(); // Go back to the previous activity
        });

        // About Button Click Listener
        aboutButton.setOnClickListener(v -> {
            Intent intent = new Intent(a_example.this, aboutus.class); // Replace 'a_about' with the appropriate class
            startActivity(intent);
        });

        // Complain Button Click Listener
        complainButton.setOnClickListener(v -> {
            Intent intent = new Intent(a_example.this, complain.class); // Replace 'a_complain' with the appropriate class
            startActivity(intent);
        });

        // Help and Support Button Click Listener
        helpButton.setOnClickListener(v -> {
            Intent intent = new Intent(a_example.this, a_help.class); // Replace 'a_help' with the appropriate class
            startActivity(intent);
        });

        // Profile Button Click Listener
        profileButton.setOnClickListener(v -> {
            Intent intent = new Intent(a_example.this, profile.class); // Replace 'a_profile' with the appropriate class
            startActivity(intent);
        });

        // Set Pass Button Click Listener
        setPassButton.setOnClickListener(v -> {
            Intent intent = new Intent(a_example.this, a_setpass.class); // Replace 'a_setpass' with the appropriate class
            startActivity(intent);
        });
    }
}
