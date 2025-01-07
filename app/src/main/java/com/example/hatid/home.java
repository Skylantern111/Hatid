package com.example.hatid;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class home extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private EditText pickupLocationInput, dropoffLocationInput;
    private TextView cashLink, promoLink, notesLink;
    
    private Button bookButton;

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
        bookButton = findViewById(R.id.bookButton) ;




        // Set up Google Map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        // Set click listeners for links
        bookButton.setOnClickListener(v -> startActivity(new Intent(home.this, location.class)));

        cashLink.setOnClickListener(v -> startActivity(new Intent(home.this, cash.class)));

        promoLink.setOnClickListener(v -> startActivity(new Intent(home.this, promo.class)));

        notesLink.setOnClickListener(v -> {
            // Create and show the dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(home.this);
            View dialogView = getLayoutInflater().inflate(R.layout.dialog_note, null);

            final EditText noteEditText = dialogView.findViewById(R.id.noteEditText);
            Button submitNoteButton = dialogView.findViewById(R.id.submitNoteButton);

            builder.setView(dialogView);
            AlertDialog dialog = builder.create();

            // Handle the submit button click
            submitNoteButton.setOnClickListener(v1 -> {
                String noteMessage = noteEditText.getText().toString().trim();
                if (!noteMessage.isEmpty()) {
                    // Do something with the note (e.g., store or display it)
                    Toast.makeText(home.this, "Note submitted: " + noteMessage, Toast.LENGTH_SHORT).show();
                    dialog.dismiss(); // Close the dialog after submission
                } else {
                    Toast.makeText(home.this, "Please enter a note.", Toast.LENGTH_SHORT).show();
                }
            });

            // Show the dialog
            dialog.show();
        });
        // Set onClickListener for the pickup EditText
        pickupLocationInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, location.class);
                intent.putExtra("EDIT_TEXT_ID", "pickup"); // Pass the identifier for the clicked field
                startActivity(intent);
            }
        });

        // Set onClickListener for the dropoff EditText
        dropoffLocationInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, location.class);
                intent.putExtra("EDIT_TEXT_ID", "dropoff"); 
                startActivity(intent);
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
