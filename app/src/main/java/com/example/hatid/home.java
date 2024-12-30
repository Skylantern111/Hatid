package com.example.hatid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class home extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private EditText pickupLocationInput, dropoffLocationInput;
    private TextView cashLink, promoLink, notesLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize views
        pickupLocationInput = findViewById(R.id.pickupLocationInput);
        dropoffLocationInput = findViewById(R.id.dropoffLocationInput);
        cashLink = findViewById(R.id.cashLink);
        promoLink = findViewById(R.id.promoLink);
        notesLink = findViewById(R.id.notesLink);



        // Set up Google Map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        // Set click listeners for links
        cashLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Cash screen
                startActivity(new Intent(home.this, cash.class));
            }
        });

        promoLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Promo screen
                startActivity(new Intent(home.this, promo.class));
            }
        });

        // In your Activity or Fragment

        notesLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and show the dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(home.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_note, null);

                final EditText noteEditText = dialogView.findViewById(R.id.noteEditText);
                Button submitNoteButton = dialogView.findViewById(R.id.submitNoteButton);

                builder.setView(dialogView);
                AlertDialog dialog = builder.create();

                // Handle the submit button click
                submitNoteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String noteMessage = noteEditText.getText().toString().trim();
                        if (!noteMessage.isEmpty()) {
                            // Do something with the note (e.g., store or display it)
                            Toast.makeText(home.this, "Note submitted: " + noteMessage, Toast.LENGTH_SHORT).show();
                            dialog.dismiss(); // Close the dialog after submission
                        } else {
                            Toast.makeText(home.this, "Please enter a note.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                // Show the dialog
                dialog.show();
            }
        });


        // Set onClick listener for pickup location input
        pickupLocationInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = pickupLocationInput.getText().toString();
                if (!location.isEmpty()) {
                    // Example location for pickup
                    LatLng pickupLocation = new LatLng(-34, 151); // Replace with actual geolocation logic
                    mMap.addMarker(new MarkerOptions().position(pickupLocation).title("Pickup Location"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pickupLocation, 12));
                }
            }
        });

        // Set onClick listener for drop-off location input
        dropoffLocationInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = dropoffLocationInput.getText().toString();
                if (!location.isEmpty()) {
                    // Example location for drop-off
                    LatLng dropoffLocation = new LatLng(-33.9, 151.2); // Replace with actual geolocation logic
                    mMap.addMarker(new MarkerOptions().position(dropoffLocation).title("Drop-off Location"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dropoffLocation, 12));
                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a default marker and set default zoom level
        LatLng defaultLocation = new LatLng(-34, 151); // Example default location
        mMap.addMarker(new MarkerOptions().position(defaultLocation).title("Default Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 10));
    }
}
