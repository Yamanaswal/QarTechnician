package com.app.qartechnician.screens;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.app.qartechnician.R;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setData();
    }

    private void setData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Preferences.getPreference(SplashActivity.this, PrefEntities.USER).equals("1")) {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashActivity.this, SelectPreferencesActivity.class));
                    finish();
                }
            }
        }, 1000);
    }

}
