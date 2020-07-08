package com.app.qartechnician.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.NotificationDateAdapter;
import com.app.qartechnician.adapters.NotificationsAdapter;
import com.app.qartechnician.adapters.UpcomingOrderAdapter;
import com.app.qartechnician.models.Test;
import com.app.qartechnician.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class NotificationsActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    TextView bar_text;
    ImageView back_button;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        setIds();
        setData();
    }

    private void setIds() {
        toolbar = findViewById(R.id.toolbar);
        bar_text = toolbar.findViewById(R.id.bar_text);
        recyclerView = findViewById(R.id.recycler_view);
        back_button = toolbar.findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
    }

    private void setData() {
        //setting Customize Toolbar
        bar_text.setText(R.string.notifications);
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

        NotificationDateAdapter adapter = new NotificationDateAdapter(this,test);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra(Constants.BACK_KEY, "back_key");
                startActivity(intent);
                finish();
                break;
        }
    }
}
