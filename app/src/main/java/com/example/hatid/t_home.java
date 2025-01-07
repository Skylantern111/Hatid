package com.example.hatid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class t_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_home); // Make sure to set the correct XML layout

        // Initialize ImageViews
        ImageView imageViewMessages = findViewById(R.id.msgicon);
        ImageView imageViewSettings = findViewById(R.id.settingsIcon);
        ImageView imageViewHistory = findViewById(R.id.historyIcon);
        ImageView imageViewBook = findViewById(R.id.bookicon);
        ImageView profile = findViewById(R.id.profileicon);



        // Initialize TextViews
        TextView textViewHistory = findViewById(R.id.historybtn);
        TextView textViewSettings = findViewById(R.id.settingsbtn);
        TextView textViewMessages = findViewById(R.id.mgsbtn);
        TextView textViewBook = findViewById(R.id.bookbtn);
        TextView txtprofile = findViewById(R.id.profile);



        // Set OnClickListeners for ImageViews
        imageViewHistory.setOnClickListener(v -> {
            Intent intent = new Intent(t_home.this, history2.class);
            startActivity(intent);
        });

        imageViewSettings.setOnClickListener(v -> {
            Intent intent = new Intent(t_home.this, settings.class);
            startActivity(intent);
        });

        imageViewMessages.setOnClickListener(v -> {
            Intent intent = new Intent(t_home.this, complain.class);
            startActivity(intent);
        });

        imageViewBook.setOnClickListener(v -> {
            Intent intent = new Intent(t_home.this, home.class);
            startActivity(intent);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(t_home.this, profile.class);
            startActivity(intent);
        });


        // Set OnClickListeners for TextViews
        textViewHistory.setOnClickListener(v -> {
            Intent intent = new Intent(t_home.this, history2.class);
            startActivity(intent);
        });

        textViewSettings.setOnClickListener(v -> {
            Intent intent = new Intent(t_home.this, settings.class);
            startActivity(intent);
        });

        textViewMessages.setOnClickListener(v -> {
            Intent intent = new Intent(t_home.this, complain.class);
            startActivity(intent);
        });

        textViewBook.setOnClickListener(v -> {
            Intent intent = new Intent(t_home.this, home.class);
            startActivity(intent);
        });
        txtprofile.setOnClickListener(v -> {
            Intent intent = new Intent(t_home.this, profile.class);
            startActivity(intent);
        });
    }
}
