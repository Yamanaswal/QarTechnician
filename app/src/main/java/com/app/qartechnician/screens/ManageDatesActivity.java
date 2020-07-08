package com.app.qartechnician.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.ManageDatesAdapter;
import com.app.qartechnician.models.Test;
import com.app.qartechnician.utils.Constants;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class ManageDatesActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    TextView bar_text;
    ImageView back_button;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_dates);
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
        bar_text.setText(R.string.manage_dates);
        setSupportActionBar(toolbar);

        //setting RecyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        setRecyclerData();

        setBottomDialog();
    }

    private void setBottomDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.AppBottomSheetDialogTheme);
        bottomSheetDialog.setContentView(R.layout.bottom_dialog);
        bottomSheetDialog.setCancelable(true);
        Spinner spinner = bottomSheetDialog.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.service_required, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        bottomSheetDialog.show();
    }

    private void setRecyclerData() {
        List<Test> test = new ArrayList<>();
        test.add(new Test("Engine Oil Change"));
        test.add(new Test("Denting & Painting"));
        test.add(new Test("AC Gas Topup"));
        test.add(new Test("Engine Oil Change"));
        test.add(new Test("Denting & Painting"));
        test.add(new Test("AC Gas Topup"));


        ManageDatesAdapter adapter = new ManageDatesAdapter(this, test);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra(Constants.BACK_KEY, "back_key");
                startActivity(intent);
                break;
        }
    }
}
