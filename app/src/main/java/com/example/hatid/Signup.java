package com.example.hatid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Use the correct button ID from the XML layout
        Button backButton = findViewById(R.id.backbtn);
        Button button = findViewById(R.id.button);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the Login activity
                Intent intent = new Intent(Signup.this, dashboard.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the Login activity
                Intent intent = new Intent(Signup.this, a_example.class);
                startActivity(intent);
            }
        });
    }
}
