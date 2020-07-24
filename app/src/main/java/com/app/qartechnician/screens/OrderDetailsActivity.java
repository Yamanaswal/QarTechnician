package com.app.qartechnician.screens;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.OrderDetailsAdapter;
import com.app.qartechnician.models.Test;
import com.app.qartechnician.models.ongoing_order.ongoing_order_request.OnGoingOrderRequest;
import com.app.qartechnician.models.ongoing_order.ongoing_order_response.OnGoingOrderResponse;
import com.app.qartechnician.models.ongoing_order.ongoing_order_response.OnGoingOrderResponseData;
import com.app.qartechnician.retrofit.retrofit_service.APIUtility;
import com.app.qartechnician.utils.CommonUtils;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    TextView bar_text;
    ImageView back_button;
    RecyclerView recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        setIds();
        setData();
    }

    private void setData() {
        //setting Customize Toolbar
        bar_text.setText("Order Details");
        setSupportActionBar(toolbar);
        hitApi();

    }

    private void hitApi() {

        OnGoingOrderRequest request = new OnGoingOrderRequest();
        String bookingId = getIntent().getStringExtra("bookingId");
        request.setBookingId("5f031d9486d43318d7d6393b");

        new APIUtility().ongoingOrder(this, true,
                Preferences.getPreference(this, PrefEntities.ACCESS_TOKEN), request, new APIUtility.APIResponseListener<OnGoingOrderResponse>() {
                    @Override
                    public void onReceiveResponse(OnGoingOrderResponse response) {
                        Log.d("OnGoingOrderRequest", response.getData().toString());
                        setRecyclerView(response.getData());
                    }

                    @Override
                    public void onStatusFailed(OnGoingOrderResponse response) {
                        Toast.makeText(OrderDetailsActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure() {
                        CommonUtils.alert(OrderDetailsActivity.this, getString(R.string.somethingwentwrong));
                    }
                });

    }

    private void setRecyclerView(List<OnGoingOrderResponseData> data) {
        List<Test> test = new ArrayList<>();
        test.add(new Test("Engine Oil Change"));
        test.add(new Test("Denting & Painting"));

        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        OrderDetailsAdapter orderDetailsAdapter = new OrderDetailsAdapter(OrderDetailsActivity.this, test);
        recycler_view.setAdapter(orderDetailsAdapter);
    }

    private void setIds() {
        toolbar = findViewById(R.id.toolbar);
        bar_text = toolbar.findViewById(R.id.bar_text);
        back_button = toolbar.findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
        recycler_view = findViewById(R.id.recycler_view);
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
