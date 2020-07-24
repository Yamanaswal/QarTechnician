package com.app.qartechnician.screens;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.qartechnician.R;

public class SelectLocationActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView bar_text;
    ImageView back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location);

        setIds();
        setData();
    }


    private void setIds() {
        toolbar = findViewById(R.id.toolbar);
        bar_text = toolbar.findViewById(R.id.bar_text);
        back_button = toolbar.findViewById(R.id.back_button);
    }

    private void setData() {
        //setting Customize Toolbar
        bar_text.setText(R.string.search_location);
        setSupportActionBar(toolbar);
    }


}