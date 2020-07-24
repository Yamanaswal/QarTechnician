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
import com.app.qartechnician.adapters.TodayJobAdapter;
import com.app.qartechnician.models.Test;
import com.app.qartechnician.models.todays_job.todays_job_request.TodayJobRequest;
import com.app.qartechnician.models.todays_job.todays_job_response.TodayJobResponse;
import com.app.qartechnician.retrofit.retrofit_service.APIUtility;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;

import java.util.ArrayList;
import java.util.List;

public class TodayJobActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    TextView bar_text;
    RecyclerView recyclerView;
    ImageView back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todays_job);
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
        bar_text.setText(R.string.today_job);
        setSupportActionBar(toolbar);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setRecyclerData();
    }

    private void setRecyclerData() {

        hitApiTodayJob();
        List<Test> test = new ArrayList<>();
        test.add(new Test("Engine Oil Change"));
        test.add(new Test("Denting & Painting"));
        test.add(new Test("AC Gas Topup"));
        test.add(new Test("General Inspection"));
        test.add(new Test("Engine Oil Change"));

        TodayJobAdapter adapter = new TodayJobAdapter(this, test);
        recyclerView.setAdapter(adapter);
    }


    private void hitApiTodayJob() {

        TodayJobRequest request = new TodayJobRequest();
        request.setLoginAs(Preferences.getPreference(this, PrefEntities.LOGIN_AS));
        new APIUtility().todayJob(this, true, Preferences.getPreference(this, PrefEntities.ACCESS_TOKEN), request, new APIUtility.APIResponseListener<TodayJobResponse>() {
            @Override
            public void onReceiveResponse(TodayJobResponse response) {

            }

            @Override
            public void onStatusFailed(TodayJobResponse response) {

            }

            @Override
            public void onFailure() {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
