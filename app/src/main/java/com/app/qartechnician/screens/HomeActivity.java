package com.app.qartechnician.screens;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.app.qartechnician.R;
import com.app.qartechnician.fragments.home_fragments.AppointmentsFragment;
import com.app.qartechnician.fragments.home_fragments.ChatFragment;
import com.app.qartechnician.fragments.home_fragments.HomePageFragment;
import com.app.qartechnician.fragments.home_fragments.ProfileFragment;
import com.app.qartechnician.fragments.home_fragments.TransactionHistoryFragment;
import com.app.qartechnician.utils.Constants;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setIds();
        setData(savedInstanceState);
    }

    private void setIds() {
        bottom_navigation = findViewById(R.id.bottom_navigation);
    }

    private void setData(Bundle savedInstanceState) {

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new HomePageFragment()).commit();
        }

        //set Profile Page
        String back_key = getIntent().getStringExtra(Constants.BACK_KEY);
        if (back_key != null && !back_key.isEmpty()) {
            if (back_key.equals("back_key")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new ProfileFragment()).commit();
            }
        }

        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                new HomePageFragment()).commit();
                        break;

                    case R.id.appointments:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                new AppointmentsFragment()).commit();
                        break;

                    case R.id.chat:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                new ChatFragment()).commit();
                        break;

                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                new ProfileFragment()).commit();
                        break;
                }
                return true;
            }
        });
    }
}
