package com.example.hatid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class location extends AppCompatActivity {
    private TextView addhome, addschool, addwork, addother;
    private boolean pickupSelected = false;
    private boolean dropoffSelected = false;
    private Button bookButton;

    // Track selected addresses
    private String selectedPickupAddress = "";
    private String selectedDropoffAddress = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_location); // Ensure your XML layout is correct

        // Initialize views
        addhome = findViewById(R.id.addhome);
        addschool = findViewById(R.id.addschool);
        addwork = findViewById(R.id.addwork);
        addother = findViewById(R.id.addother);
        AutoCompleteTextView pickupInput = findViewById(R.id.PickupInput);
        AutoCompleteTextView dropoffInput = findViewById(R.id.dropoffInput);
        bookButton = findViewById(R.id.bookButton);

        // Example address suggestions
        String[] addressSuggestions = {
                " Avenida del Sol, Barangay Poblacion, Makati City, Metro Manila",
                " Adobo Barangay Maligaya, Kalayaan Road, San Juan, Metro Manila",
                " Danao Street, Barangay Sto. Niño, Cebu City, Cebu",
                " Anaknak Ermita Street, Barangay Ermita, Manila, Metro Manila",
                " Fortune Street, Barangay Mandaluyong, Mandaluyong City, Metro Manila",
                " Gabi Street, Barangay Pasong Tamo, Quezon City, Metro Manila",
                " Hacienda San Isidro, Barangay Paraiso, Makati City, Metro Manila",
                "Isabela Lane, Barangay Matina, Davao City, Davao del Sur",
                "Juan Luna Street, Barangay San Roque, Tarlac City, Tarlac",
                "Kanto Street, Barangay Bagumbayan, Taguig City, Metro Manila",
                "11 - Lantana Drive, Barangay Pagsanjan, Pasig City, Metro Manila",
                "11 - Maria Clara Avenue, Barangay Bahay Toro, Quezon City, Metro Manila",
                "11 - Nueva Street, Barangay San Rafael, Iloilo City, Iloilo",
                "11 - Ocampo Road, Barangay Victoria, Batangas City, Batangas",
                "111 - Pio Del Pilar Street, Barangay Pilar, Makati City, Metro Manila",
                "555 - Quezon Avenue, Barangay Diliman, Quezon City, Metro Manila",
                "55 - Rizal Boulevard, Barangay Malate, Manila, Metro Manila",
                "555 - Sampaloc Street, Barangay San Nicolas, Manila, Metro Manila",
                "553 - Tarlac Street, Barangay Salapungan, Tarlac City, Tarlac",
                "334 - Urdaneta Road, Barangay Sampaloc, Quezon City, Metro Manila",
                "804 - Victoria Street, Barangay Longos, Bacoor, Cavite",
                "275 - West Avenue, Barangay Bagumbayan, Quezon City, Metro Manila"
        };

        // Set up adapters for suggestions
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, addressSuggestions);
        pickupInput.setAdapter(adapter);
        dropoffInput.setAdapter(adapter);

        // Add clear ("X") functionality
        setupClearFunctionality(pickupInput);
        setupClearFunctionality(dropoffInput);

        // Ensure that suggestions can be clicked
        pickupInput.setOnItemClickListener((parent, view, position, id) -> {
            String selectedAddress = (String) parent.getItemAtPosition(position);
            if (selectedAddress.equals(selectedDropoffAddress)) {
                // Show toast message if address is already selected in dropoff
                Toast.makeText(location.this, "This address is already selected for Dropoff", Toast.LENGTH_SHORT).show();
            } else {
                selectedPickupAddress = selectedAddress;
                pickupSelected = true;
            }
        });

        dropoffInput.setOnItemClickListener((parent, view, position, id) -> {
            String selectedAddress = (String) parent.getItemAtPosition(position);
            if (selectedAddress.equals(selectedPickupAddress)) {
                // Show toast message if address is already selected in pickup
                Toast.makeText(location.this, "This address is already selected for Pickup", Toast.LENGTH_SHORT).show();
            } else {
                selectedDropoffAddress = selectedAddress;
                dropoffSelected = true;
            }
        });

        // Watch for text changes and disable "selected" flags when input is cleared
        pickupInput.addTextChangedListener(createTextWatcher(() -> pickupSelected = false));
        dropoffInput.addTextChangedListener(createTextWatcher(() -> dropoffSelected = false));

        // Book button logic
        bookButton.setOnClickListener(v -> {
            if (pickupSelected && dropoffSelected) {
                // Show loading dialog
                showLoadingDialog();

                // Delay for 7 seconds before navigating to the booking screen
                new Handler().postDelayed(() -> {
                    // After 7 seconds, dismiss the loading dialog and proceed to the next activity
                    dismissLoadingDialog();

                    // Navigate to BookingActivity or desired activity
                    Intent intent = new Intent(location.this, act_booking.class); // Replace act_booking with your actual class
                    startActivity(intent);
                }, 7000);
            } else {
                // Show toast message
                Toast.makeText(location.this, "Please choose a valid location for both fields", Toast.LENGTH_SHORT).show();
            }
        });

        // Set up click listeners for location selection
        addhome.setOnClickListener(view -> openLoc2("Home"));
        addschool.setOnClickListener(view -> openLoc2("School"));
        addwork.setOnClickListener(view -> openLoc2("Work"));
        addother.setOnClickListener(view -> openLoc2("Another Place"));
    }

    // Helper method to handle intent for location selection
    private void openLoc2(String addressType) {
        Intent intent = new Intent(location.this, loc2.class);
        intent.putExtra("ADDRESS_TYPE", addressType); // Pass address type to next activity
        startActivity(intent);
    }

    // Loading dialog related methods
    private AlertDialog loadingDialog;

    private void showLoadingDialog() {
        // Inflate the custom layout
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_waiting, null);

        // Create an AlertDialog builder and set the custom view
        AlertDialog.Builder builder = new AlertDialog.Builder(location.this);
        builder.setCancelable(false); // Prevent dialog from being dismissed
        builder.setView(dialogView);

        // Create and show the dialog
        loadingDialog = builder.create();
        loadingDialog.show();
    }

    private void dismissLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }


    // Helper method to add clear ("X") functionality
    @SuppressLint("ClickableViewAccessibility")
    private void setupClearFunctionality(AutoCompleteTextView input) {
        Drawable clearIcon = getResources().getDrawable(android.R.drawable.ic_menu_close_clear_cancel);
        input.setCompoundDrawablesWithIntrinsicBounds(null, null, clearIcon, null);

        input.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getX() >= (input.getWidth() - input.getCompoundDrawables()[2].getBounds().width())) {
                    input.setText(""); // Clear the text
                    input.setCompoundDrawablesWithIntrinsicBounds(null, null, clearIcon, null);
                    return true;
                }
            }
            return false;
        });
    }

    // Helper method to create a TextWatcher
    private TextWatcher createTextWatcher(Runnable onTextCleared) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    onTextCleared.run();
                }
            }
        };
    }
}
