package com.example.hatid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Use a Handler to add a delay before transitioning to Login page
        new Handler().postDelayed(() -> {
            // Create an Intent to move to the Login activity
            Intent intent = new Intent(MainActivity.this, dashboard.class);
            startActivity(intent); // Start the Login activity
            finish(); // Close MainActivity
        }, 3000); // 3000 milliseconds (3 seconds) delay before transitioning
    }
}
