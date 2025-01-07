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
        Button privacy = findViewById(R.id.privacy);
        Button Contact = findViewById(R.id.Contact);
        Button delete = findViewById(R.id.delete);
        Button about = findViewById(R.id.a_about);


        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this, t_home.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        });

        // About Button Click Listener
        Changepass.setOnClickListener(v -> {
            Intent intent = new Intent(settings.this, s_changepass.class);
            startActivity(intent);
        });



        privacy.setOnClickListener(v -> {
            Intent intent = new Intent(settings.this, s_privacy.class);
            startActivity(intent);
        });

        Contact.setOnClickListener(v -> {
            Intent intent = new Intent(settings.this, s_contactus.class);
            startActivity(intent);
        });

        delete.setOnClickListener(v -> {
            Intent intent = new Intent(settings.this, s_delete.class);
            startActivity(intent);

        });

        // About Button Click Listener
        about.setOnClickListener(v -> {
            Intent intent = new Intent(settings.this, aboutus.class); // Replace 'a_about' with the appropriate class
            startActivity(intent);
        });



    }
}
