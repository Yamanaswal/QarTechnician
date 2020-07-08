package com.app.qartechnician.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.qartechnician.R;
import com.app.qartechnician.utils.CommonUtils;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;

public class SelectPreferencesActivity extends AppCompatActivity implements View.OnClickListener {

    //Log In As Technician
    private int technician = 0;

    private TextView technician_text, garage_owner_text;
    private ImageView tech_tick, garage_tick, back_button;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_preferences);
        setData();
    }

    private void setData() {
        //Setting Ids
        setIds();
    }

    private void setIds() {
        findViewById(R.id.continue_button).setOnClickListener(this);
        findViewById(R.id.technician_select).setOnClickListener(this);
        findViewById(R.id.garage_owner_select).setOnClickListener(this);

        garage_owner_text = findViewById(R.id.garage_owner_text);
        technician_text = findViewById(R.id.technician_text);
        garage_tick = findViewById(R.id.garage_tick);
        tech_tick = findViewById(R.id.tech_tick);
        toolbar = findViewById(R.id.toolbar);
        back_button = toolbar.findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.continue_button:
                //Log In As Technician
                if (technician == 1) {
                    Intent intent = new Intent(SelectPreferencesActivity.this, LoginActivity.class);
                    Preferences.setPreference(this, PrefEntities.LOGIN_AS,"technician");
                    startActivity(intent);
                    finish();
                }
                //Log In As Garage Owner
                else if (technician == 0) {
                    Intent intent = new Intent(SelectPreferencesActivity.this, LoginActivity.class);
                    Preferences.setPreference(this,PrefEntities.LOGIN_AS,"garageOwner");
                    startActivity(intent);
                    finish();
                }
                break;

            case R.id.technician_select:
                garage_owner_text.setTextColor(getResources().getColor(R.color.black_dot_color));
                technician_text.setTextColor(getResources().getColor(R.color.orange_colour));
                tech_tick.setVisibility(View.VISIBLE);
                garage_tick.setVisibility(View.GONE);
                technician = 1;
                break;

            case R.id.garage_owner_select:
                garage_owner_text.setTextColor(getResources().getColor(R.color.orange_colour));
                technician_text.setTextColor(getResources().getColor(R.color.black_dot_color));
                garage_tick.setVisibility(View.VISIBLE);
                tech_tick.setVisibility(View.GONE);
                technician = 0;
                break;


            case R.id.back_button:
                CommonUtils.AlertDialogCloseApp(this, "Qar Technician", "Do you want to close App?");
                break;
        }
    }


}
