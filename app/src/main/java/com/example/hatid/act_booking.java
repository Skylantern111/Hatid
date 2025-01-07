package com.example.hatid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class act_booking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking); // Make sure this matches your layout name

        // Find the bookButton by its ID
        Button bookButton = findViewById(R.id.bookButton);

        // Set an OnClickListener for the button
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to go to the location activity
                Intent intent = new Intent(act_booking.this, location.class);
                startActivity(intent); // Start the new activity
            }
        });
    }
}
