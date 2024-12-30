package com.example.hatid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard1); // Ensure this is correct

        // Button reference
        Button button5 = findViewById(R.id.button5); // Ensure this matches XML

        // Set OnClickListener to the button
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new activity that uses dashboard2.xml
                Intent intent = new Intent(welcome.this, dashboard2.class);
                startActivity(intent);
            }
        });
    }
}
