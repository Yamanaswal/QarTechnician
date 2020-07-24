package com.app.qartechnician.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.NotificationsAdapter;
import com.app.qartechnician.models.notifications.notification_response.NotificationResponse;
import com.app.qartechnician.retrofit.retrofit_service.APIUtility;
import com.app.qartechnician.utils.CommonUtils;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;

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

        new APIUtility().notifications(this, true,
                Preferences.getPreference(this, PrefEntities.ACCESS_TOKEN), new APIUtility.APIResponseListener<NotificationResponse>() {
                    @Override
                    public void onReceiveResponse(NotificationResponse response) {
                        if (response.getCode() == 1) {
                            NotificationsAdapter adapter = new NotificationsAdapter(NotificationsActivity.this, response.getData());
                            recyclerView.setAdapter(adapter);
                        } else {
                            Toast.makeText(NotificationsActivity.this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onStatusFailed(NotificationResponse response) {
                        Toast.makeText(NotificationsActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure() {
                        CommonUtils.alert(NotificationsActivity.this, getString(R.string.somethingwentwrong));
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
