package com.app.qartechnician.fragments.appointments_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.CompletedAdapter;
import com.app.qartechnician.models.my_appointment.my_appointment_request.MyAppointmentRequest;
import com.app.qartechnician.models.my_appointment.my_appointment_response.MyAppointmentResponse;
import com.app.qartechnician.models.my_appointment.my_appointment_response.MyAppointmentResponseData;
import com.app.qartechnician.retrofit.retrofit_service.APIUtility;
import com.app.qartechnician.utils.CommonUtils;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;

import java.util.List;

public class CompletedFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;

    public CompletedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_completed, container, false);
        setIds();
        setData();
        return view;
    }


    private void setIds() {
        recyclerView = view.findViewById(R.id.recycler_view);
    }

    private void setData() {
        hitApiCompleted();
    }

    private void hitApiCompleted() {

        MyAppointmentRequest request = new MyAppointmentRequest();
        request.setLoginAs(Preferences.getPreference(getContext(), PrefEntities.LOGIN_AS));
        request.setStatus("completed");

        new APIUtility().myAppointment(getContext(), true,
                Preferences.getPreference(getActivity(), PrefEntities.ACCESS_TOKEN),
                request, new APIUtility.APIResponseListener<MyAppointmentResponse>() {
                    @Override
                    public void onReceiveResponse(MyAppointmentResponse response) {
                        if (response != null && response.getCode() == 1) {
                            setRecyclerData(response.getData());
                        }
                    }

                    @Override
                    public void onStatusFailed(MyAppointmentResponse response) {
                        Toast.makeText(getContext(), response.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure() {
                        CommonUtils.alert(getContext(), getString(R.string.somethingwentwrong));
                    }
                });
    }


    private void setRecyclerData(List<MyAppointmentResponseData> data) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        if (isAdded()) {
            CompletedAdapter adapter = new CompletedAdapter(getContext(), data);
            recyclerView.setAdapter(adapter);
        }
    }


}
