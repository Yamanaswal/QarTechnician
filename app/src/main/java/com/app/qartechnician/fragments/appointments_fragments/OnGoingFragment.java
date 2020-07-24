package com.app.qartechnician.fragments.appointments_fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.OnGoingAdapter;
import com.app.qartechnician.models.my_appointment.my_appointment_request.MyAppointmentRequest;
import com.app.qartechnician.models.my_appointment.my_appointment_response.MyAppointmentResponse;
import com.app.qartechnician.models.my_appointment.my_appointment_response.MyAppointmentResponseData;
import com.app.qartechnician.retrofit.retrofit_service.APIUtility;
import com.app.qartechnician.utils.CommonUtils;
import com.app.qartechnician.utils.PrefEntities;
import com.app.qartechnician.utils.Preferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class OnGoingFragment extends Fragment implements View.OnClickListener {

    private View view;
    private RecyclerView recyclerView;
    RelativeLayout date_picker_start, date_picker_end;
    DatePickerDialog.OnDateSetListener date;
    final Calendar myCalendar = Calendar.getInstance();
    MyAppointmentRequest request = new MyAppointmentRequest();

    public OnGoingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_on_going, container, false);
        setIds();
        setData();
        return view;
    }


    private void setIds() {
        recyclerView = view.findViewById(R.id.recycler_view);
        date_picker_start = view.findViewById(R.id.date_picker_start);
        date_picker_end = view.findViewById(R.id.date_picker_end);
    }

    private void setData() {

        hitApi();
        setDatePicker();

    }

    private void hitApi() {

        request.setLoginAs(Preferences.getPreference(getContext(), PrefEntities.LOGIN_AS));
        request.setStatus("ongoing");


        new APIUtility().myAppointment(getContext(), true, Preferences.getPreference(getActivity(), PrefEntities.ACCESS_TOKEN), request, new APIUtility.APIResponseListener<MyAppointmentResponse>() {
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

    private void setDatePicker() {

        date_picker_start.setOnClickListener(this);
        date_picker_end.setOnClickListener(this);

        date = (view, year, monthOfYear, dayOfMonth) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        };

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        Toast.makeText(getContext(), "" + sdf.format(myCalendar.getTime()), Toast.LENGTH_SHORT).show();
    }

    private void setRecyclerData(List<MyAppointmentResponseData> data) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        if (isAdded()) {
            OnGoingAdapter adapter = new OnGoingAdapter(getContext(), data);
            recyclerView.setAdapter(adapter);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.date_picker_start:
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                break;

            case R.id.date_picker_end:
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
        }
    }
}
