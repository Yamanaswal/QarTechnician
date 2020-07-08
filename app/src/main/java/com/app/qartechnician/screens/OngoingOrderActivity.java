package com.app.qartechnician.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.OngoingOrderAdapter;
import com.app.qartechnician.models.Test;

import java.util.ArrayList;
import java.util.List;

public class OngoingOrderActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    TextView bar_text;
    RecyclerView recyclerView;
    ImageView back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing_order);
        setIds();
        setData();
    }

    private void setIds() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycler_view);
        back_button = toolbar.findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
        bar_text = toolbar.findViewById(R.id.bar_text);
    }

    private void setData() {
        //setting Customize Toolbar
        bar_text.setText(R.string.ongoing_order);
        setSupportActionBar(toolbar);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setRecyclerData();


    }

    private void setRecyclerData() {
        List<Test> test = new ArrayList<>();
        test.add(new Test("Engine Oil Change"));
        test.add(new Test("Denting & Painting"));
        test.add(new Test("AC Gas Topup"));
        test.add(new Test("General Inspection"));
        test.add(new Test("Engine Oil Change"));

        OngoingOrderAdapter adapter = new OngoingOrderAdapter(this, test);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.back_button:
                startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
        }
    }
}
