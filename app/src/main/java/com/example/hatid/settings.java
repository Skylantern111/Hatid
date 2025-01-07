package com.example.hatid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageView backArrow = findViewById(R.id.backArrow);
        Button Changepass = findViewById(R.id.Changepass);
        Button Changelang = findViewById(R.id.Changelang);
        Button privacy = findViewById(R.id.privacy);
        Button Contact = findViewById(R.id.Contact);
        Button delete = findViewById(R.id.delete);
        Button booking = findViewById(R.id.booking);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this, home.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        });

        // About Button Click Listener
        Changepass.setOnClickListener(v -> {
            Intent intent = new Intent(settings.this, s_changepass.class); 
            startActivity(intent);
        });




        Changelang.setOnClickListener(v -> {
            Intent intent = new Intent(settings.this, s_changelang.class);
            startActivity(intent);
            finish();
        });

        privacy.setOnClickListener(v -> {
            Intent intent = new Intent(settings.this, s_privacy.class);
            startActivity(intent);
            finish();
        });

        Contact.setOnClickListener(v -> {
            Intent intent = new Intent(settings.this, s_contactus.class);
            startActivity(intent);
            finish();
        });

        delete.setOnClickListener(v -> {
            Intent intent = new Intent(settings.this, s_delete.class);
            startActivity(intent);
            finish();
        });

        booking.setOnClickListener(v -> {
            Intent intent = new Intent(settings.this, act_booking.class);
            startActivity(intent);
            finish();
        });

    }
}
