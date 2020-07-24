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
import android.widget.Toast;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.UpcomingOrderAdapter;
import com.app.qartechnician.models.upcoming_order.upcoimg_order_response.UpcomingOrderResponse;
import com.app.qartechnician.models.upcoming_order.upcoming_order_request.UpcomingOrderRequest;
import com.app.qartechnician.retrofit.retrofit_service.APIUtility;
import com.app.qartechnician.utils.CommonUtils;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;

public class UpcomingOrderActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    TextView bar_text;
    RecyclerView recyclerView;
    ImageView back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_order);
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
        bar_text.setText(R.string.upcoming_order);
        setSupportActionBar(toolbar);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setRecyclerData();
    }

    private void setRecyclerData() {

        UpcomingOrderRequest request = new UpcomingOrderRequest();
        request.setLoginAs(Preferences.getPreference(this, PrefEntities.LOGIN_AS));
        String token = Preferences.getPreference(this,PrefEntities.ACCESS_TOKEN);

        new APIUtility().upcomingOrder(UpcomingOrderActivity.this, true, token, request, new APIUtility.APIResponseListener<UpcomingOrderResponse>() {
            @Override
            public void onReceiveResponse(UpcomingOrderResponse response) {
                if (response != null) {
                    UpcomingOrderAdapter adapter = new UpcomingOrderAdapter(UpcomingOrderActivity.this,response.getData());
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(UpcomingOrderActivity.this, "Code: " + response.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStatusFailed(UpcomingOrderResponse response) {
                Toast.makeText(UpcomingOrderActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure() {
                CommonUtils.alert(UpcomingOrderActivity.this, getString(R.string.somethingwentwrong));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {

            case R.id.back_button:
                startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
        }
    }
}
