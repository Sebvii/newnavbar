package com.example.navbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        // Set default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }

        // Set navigation item selection listener
        bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);
    }

    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;

        if (item.getItemId() == R.id.nav_home) {
            selectedFragment = new HomeFragment();
        } else if (item.getItemId() == R.id.nav_footprint) {
            selectedFragment = new FootPrintFragment();
        } else if (item.getItemId() == R.id.nav_rewards) {
            selectedFragment = new RewardsFragment();
        } else if (item.getItemId() == R.id.nav_profile) {
            selectedFragment = new ProfileFragment();
        }

        if (selectedFragment != null) {
            // Begin a transaction and replace the container with the selected fragment
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            return true;
        } else {
            return false;
        }
    }
}