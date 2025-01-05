package com.example.hatid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hatid.R;

public class complain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_complain);
        ImageView backArrow = findViewById(R.id.backArrow);

        backArrow.setOnClickListener(v -> {
            finish(); // Go back to the previous activity
        });


    }
}
