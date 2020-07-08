package com.app.qartechnician.fragments.home_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.HomePageAdapter;
import com.app.qartechnician.models.Test;
import com.app.qartechnician.models.dashboard_data.dashboard_data_request.DashboardDataRequest;
import com.app.qartechnician.models.dashboard_data.dashboard_data_response.DashboardDataResponse;
import com.app.qartechnician.retrofit.retrofit_service.APIUtility;
import com.app.qartechnician.screens.HomeActivity;
import com.app.qartechnician.screens.LoginActivity;
import com.app.qartechnician.screens.NotificationsActivity;
import com.app.qartechnician.screens.OngoingOrderActivity;
import com.app.qartechnician.screens.QarWalletActivity;
import com.app.qartechnician.screens.TodayJobActivity;
import com.app.qartechnician.screens.UpcomingOrderActivity;
import com.app.qartechnician.utils.CommonUtils;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment implements View.OnClickListener {

    private CardView upcoming_order, ongoing_order, today_job;
    private ImageView wallet, notification;
    private View view;
    private RecyclerView recyclerView;
    private int upcommingAppointments,ongoingAppointments,todayAppointments,notifications;
    private double wallet_amount;
    private TextView ongoing_no_text,upcoming_no_text;


    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_page, container, false);
        setIds();
        setData();
        return view;
    }

    private void setIds() {
        upcoming_order = view.findViewById(R.id.card_four);
        ongoing_order = view.findViewById(R.id.card_three);
        today_job = view.findViewById(R.id.card_five);
        recyclerView = view.findViewById(R.id.recycler_view);
        wallet = view.findViewById(R.id.wallet);
        notification = view.findViewById(R.id.notification);
        upcoming_no_text = view.findViewById(R.id.upcoming_no_text);
        ongoing_no_text = view.findViewById(R.id.ongoing_no_text);

        wallet.setOnClickListener(this);
        upcoming_order.setOnClickListener(this);
        ongoing_order.setOnClickListener(this);
        today_job.setOnClickListener(this);
        notification.setOnClickListener(this);
    }

    private void setData() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        setRecyclerData();
        hitApiDashboard();
    }

    private void hitApiDashboard() {

        DashboardDataRequest request = new DashboardDataRequest();
        request.setLoginAs(Preferences.getPreference(getContext(),PrefEntities.LOGIN_AS));
        new APIUtility().dashboardData(getContext(), true, Preferences.getPreference(getContext(), PrefEntities.ACCESS_TOKEN), request, new APIUtility.APIResponseListener<DashboardDataResponse>() {
            @Override
            public void onReceiveResponse(DashboardDataResponse response) {
                if (response != null && response.getCode() == 1) {
                    upcommingAppointments = response.getData().getUpcommingAppointments();
                    ongoingAppointments = response.getData().getOngoingAppointment();
                    todayAppointments = response.getData().getTodayAppointment();
                    notifications = response.getData().getNotification();
                    wallet_amount = response.getData().getWallet();

                    ongoing_no_text.setText(String.valueOf(ongoingAppointments));
                    upcoming_no_text.setText(String.valueOf(upcommingAppointments));

                } else {
                    assert response != null;
                    Toast.makeText(getContext(), "Code: " + response.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStatusFailed(DashboardDataResponse response) {
                Toast.makeText(getContext(), response.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure() {
                CommonUtils.alert(getContext(), getString(R.string.somethingwentwrong));
            }
        });
    }

    private void setRecyclerData() {
        List<Test> test = new ArrayList<>();
        test.add(new Test("Engine Oil Change"));
        test.add(new Test("Denting & Painting"));

        HomePageAdapter adapter = new HomePageAdapter(getContext(), test);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_five:
                startActivity(new Intent(getContext(), TodayJobActivity.class).putExtra("",todayAppointments));
                getActivity().finish();
                break;

            case R.id.card_four:
                startActivity(new Intent(getContext(), UpcomingOrderActivity.class));
                getActivity().finish();
                break;

            case R.id.card_three:
                startActivity(new Intent(getContext(), OngoingOrderActivity.class));
                getActivity().finish();
                break;

            case R.id.wallet:
                startActivity(new Intent(getContext(), QarWalletActivity.class));
                getActivity().finish();
                break;

            case R.id.notification:
                startActivity(new Intent(getContext(), NotificationsActivity.class));
                getActivity().finish();
                break;
        }
    }
}
