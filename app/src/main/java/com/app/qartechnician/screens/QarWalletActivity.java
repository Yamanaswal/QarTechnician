package com.app.qartechnician.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.WalletAdapter;
import com.app.qartechnician.models.garage_money.garage_money_response.GarageMoneyResponse;
import com.app.qartechnician.models.garage_money_admin.garage_money_admin_request.GarageMoneyAdminRequest;
import com.app.qartechnician.models.garage_money_admin.garage_money_admin_response.GarageMoneyAdminResponse;
import com.app.qartechnician.retrofit.retrofit_service.APIUtility;
import com.app.qartechnician.utils.CommonUtils;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;

public class QarWalletActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    TextView bar_text, total_money;
    ImageView back_button;
    RecyclerView recyclerView;
    Button money_withdraw;
    GarageMoneyAdminRequest request = new GarageMoneyAdminRequest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qar_wallet);
        setIds();
        setData();
    }

    private void setIds() {
        toolbar = findViewById(R.id.toolbar);
        bar_text = toolbar.findViewById(R.id.bar_text);
        back_button = toolbar.findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
        recyclerView = findViewById(R.id.recycler_view);
        total_money = findViewById(R.id.total_money);
        money_withdraw = findViewById(R.id.money_withdraw);
        money_withdraw.setOnClickListener(this);
    }

    private void setData() {
        //setting Customize Toolbar
        bar_text.setText(R.string.qar_wallet);
        setSupportActionBar(toolbar);

        //setting Recycler
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setRecyclerData();
    }

    private void setRecyclerData() {

        new APIUtility().garageMoney(this, true, Preferences.getPreference(this, PrefEntities.ACCESS_TOKEN), new APIUtility.APIResponseListener<GarageMoneyResponse>() {
            @Override
            public void onReceiveResponse(GarageMoneyResponse response) {

                if (response.getCode() == 1) {
                    //Total Earning
                    total_money.setText("" + (int) response.getData().getTotalEarnings());
                    request.setWalletId(response.getData().getList().get(0).getWallet().get_id());

                    WalletAdapter adapter = new WalletAdapter(QarWalletActivity.this, response.getData().getList());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onStatusFailed(GarageMoneyResponse response) {
                Toast.makeText(QarWalletActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure() {
                CommonUtils.alert(QarWalletActivity.this, getString(R.string.somethingwentwrong));
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

            case R.id.money_withdraw:
                hitApiWithdrawMoney();
                break;
        }
    }

    private void hitApiWithdrawMoney() {

        new APIUtility().garageMoneyAdmin(this, true,
                Preferences.getPreference(this, PrefEntities.ACCESS_TOKEN), request, new APIUtility.APIResponseListener<GarageMoneyAdminResponse>() {
                    @Override
                    public void onReceiveResponse(GarageMoneyAdminResponse response) {

                        if (response.getCode() == 1) {
                            Toast.makeText(QarWalletActivity.this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(QarWalletActivity.this, "Server Error: " + response.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onStatusFailed(GarageMoneyAdminResponse response) {
                        Toast.makeText(QarWalletActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure() {
                        CommonUtils.alert(QarWalletActivity.this, getString(R.string.somethingwentwrong));
                    }
                });
    }
}
