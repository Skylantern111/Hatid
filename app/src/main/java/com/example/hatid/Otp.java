package com.example.hatid;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Otp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        // Get references to the OTP EditText fields
        EditText otpDigit1 = findViewById(R.id.otpDigit1);
        EditText otpDigit2 = findViewById(R.id.otpDigit2);
        EditText otpDigit3 = findViewById(R.id.otpDigit3);
        EditText otpDigit4 = findViewById(R.id.otpDigit4);
        Button submbtn = findViewById(R.id.submbtn);

        // Add TextWatchers to each EditText to automatically move to the next field
        otpDigit1.addTextChangedListener(new OTPTextWatcher(otpDigit1, otpDigit2));
        otpDigit2.addTextChangedListener(new OTPTextWatcher(otpDigit2, otpDigit3));
        otpDigit3.addTextChangedListener(new OTPTextWatcher(otpDigit3, otpDigit4));
        otpDigit4.addTextChangedListener(new OTPTextWatcher(otpDigit4, null));

        // Set up the submit button click listener
        submbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // After user clicks Submit, show a Toast message
                Toast.makeText(Otp.this, "Number Verified", Toast.LENGTH_SHORT).show();

                // Navigate to the welcome page (new activity)
                Intent intent = new Intent(Otp.this, welcome.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // Custom TextWatcher class for OTP EditTexts
    private static class OTPTextWatcher implements TextWatcher {
        private EditText currentEditText;
        private EditText nextEditText;

        public OTPTextWatcher(EditText currentEditText, EditText nextEditText) {
            this.currentEditText = currentEditText;
            this.nextEditText = nextEditText;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // If current EditText has 1 digit, move focus to the next EditText
            if (editable.length() == 1 && nextEditText != null) {
                nextEditText.requestFocus();
            }
        }
    }
}
