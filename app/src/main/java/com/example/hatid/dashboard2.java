package com.example.hatid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class dashboard2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);   // Button reference
        Button button5 = findViewById(R.id.button5);
        Button skip  = findViewById(R.id.skip);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new activity that uses dashboard2.xml
                Intent intent = new Intent(dashboard2.this, dashboard3.class);
                startActivity(intent);

            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new activity that uses dashboard2.xml
                Intent intent = new Intent(dashboard2.this, t_home
                        .class);
                startActivity(intent);
            }
        });
    }
}

