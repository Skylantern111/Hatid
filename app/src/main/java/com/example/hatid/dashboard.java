package com.example.hatid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class dashboard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Find the login button by ID
        Button loginButton = findViewById(R.id.logbtn);

        // Find the create button by ID
        Button crtButton = findViewById(R.id.crtbtn);

        // Set an OnClickListener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the Login activity
                Intent intent = new Intent(dashboard.this, Login.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener for the create button
        crtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the Create account activity
                Intent intent = new Intent(dashboard.this, Signup.class); // Replace CreateAccount.class with your desired activity
                startActivity(intent);
            }
        });
    }
}
