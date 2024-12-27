package com.example.hatid;

import android.annotation.SuppressLint;
import android.content.Intent; // Import this for Intent
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize the UI elements using findViewById
        TextView textView3 = findViewById(R.id.textView3);
        EditText phoneNumberInput = findViewById(R.id.phone_number_input);
        Button loginButton = findViewById(R.id.button);
        Button signupButton = findViewById(R.id.button2);

        // Example: Set text for TextView
        textView3.setText("Please enter your phone number:");

        // Set OnClickListener for login button
        loginButton.setOnClickListener(v -> {
            // Navigate to OTP Activity
            Intent intent = new Intent(Login.this, Otp.class);
            startActivity(intent);
        });

        // Set OnClickListener for signup button
        signupButton.setOnClickListener(v -> {
            // Navigate to Signup Activity
            Intent intent = new Intent(Login.this, Signup.class);
            startActivity(intent);
        });

    }
}
