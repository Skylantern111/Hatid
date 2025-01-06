package com.example.hatid;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.tabs.TabLayout;

public class history extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        // Initialize the TabLayout
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        // Get references to the layouts
        LinearLayout upcomingLayout = findViewById(R.id.upcomingLayout);
        LinearLayout completedLayout = findViewById(R.id.completedLayout);
        LinearLayout canceledLayout = findViewById(R.id.canceledLayout);

        // Set up TabLayout listener to switch between layouts
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0: // Upcoming Tab
                        upcomingLayout.setVisibility(View.VISIBLE);
                        completedLayout.setVisibility(View.GONE);
                        canceledLayout.setVisibility(View.GONE);
                        break;

                    case 1: // Completed Tab
                        upcomingLayout.setVisibility(View.GONE);
                        completedLayout.setVisibility(View.VISIBLE);
                        canceledLayout.setVisibility(View.GONE);
                        break;

                    case 2: // Canceled Tab
                        upcomingLayout.setVisibility(View.GONE);
                        completedLayout.setVisibility(View.GONE);
                        canceledLayout.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // No action needed
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // No action needed
            }
        });

        // Add tabs to the TabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Upcoming"));
        tabLayout.addTab(tabLayout.newTab().setText("Completed"));
        tabLayout.addTab(tabLayout.newTab().setText("Canceled"));
    }
}
