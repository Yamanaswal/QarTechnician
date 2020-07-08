package com.app.qartechnician.screens;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.CreateInspectionAdapter;
import com.app.qartechnician.models.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateInspectionReportActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    TextView bar_text;
    ImageView back_button;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_inspection_report);
        setIds();
        setData();
    }

    private void setIds() {
        toolbar = findViewById(R.id.toolbar);
        bar_text = toolbar.findViewById(R.id.bar_text);
        back_button = toolbar.findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
        recyclerView = findViewById(R.id.recycler_view);
    }

    private void setData() {
        //setting Customize Toolbar
        bar_text.setText(R.string.create_inspection_report);
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

        CreateInspectionAdapter adapter = new CreateInspectionAdapter(this, test);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                break;
        }
    }
}
