package com.app.qartechnician.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
import com.app.qartechnician.models.calendar_management.calendar_management_request.CalendarManageRequest;
import com.app.qartechnician.utils.Constants;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ManageDatesActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    TextView bar_text;
    ImageView back_button;
    RecyclerView recyclerView;
    MaterialCalendarView calender_view;
    Calendar calendar = Calendar.getInstance();

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
        calender_view = findViewById(R.id.calender_view);
        //for testing.

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        calender_view.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(year, month, day))
                .setCalendarDisplayMode(CalendarMode.WEEKS)
                .commit();

        calender_view.setSelectedDate(CalendarDay.today());
    }

    private void setData() {
        //setting Customize Toolbar
        bar_text.setText(R.string.manage_dates);
        setSupportActionBar(toolbar);

        hitApiManageDate();
    }

    private void hitApiManageDate() {

        setCalender();

//        CalendarViewRequest request = new CalendarViewRequest();
//        request.setBookingDate("2020-05-29");
//
//        new APIUtility().calendarView(this, true, request, new APIUtility.APIResponseListener<CalendarViewResponse>() {
//            @Override
//            public void onReceiveResponse(CalendarViewResponse response) {
//                //setting RecyclerView
//
//            }
//
//            @Override
//            public void onStatusFailed(CalendarViewResponse response) {
//                Toast.makeText(ManageDatesActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure() {
//                CommonUtils.alert(ManageDatesActivity.this, getString(R.string.somethingwentwrong));
//            }
//        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(ManageDatesActivity.this, 2));
        setRecyclerData();

        CalendarManageRequest request1 = new CalendarManageRequest();
        request1.setTime("08:00");
        request1.setBookingDate("2020-05-27");
        request1.setReason("another work");
        request1.setStatus("available");

        //        new APIUtility().calendarManage(this, true,
//                Preferences.getPreference(this, PrefEntities.ACCESS_TOKEN),
//                request1, new APIUtility.APIResponseListener<CalendarManageResponse>() {
//                    @Override
//                    public void onReceiveResponse(CalendarManageResponse response) {
//
//                    }
//
//                    @Override
//                    public void onStatusFailed(CalendarManageResponse response) {
//                        Toast.makeText(ManageDatesActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onFailure() {
//                        CommonUtils.alert(ManageDatesActivity.this, getString(R.string.somethingwentwrong));
//                    }
//                });

    }

    private void setCalender() {

    }

//
//    private void setBottomDialog() {
//        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.AppBottomSheetDialogTheme);
//        bottomSheetDialog.setContentView(R.layout.bottom_dialog);
//        bottomSheetDialog.setCancelable(true);
//        Spinner spinner = bottomSheetDialog.findViewById(R.id.spinner);
//        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.service_required, android.R.layout.simple_spinner_item);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(arrayAdapter);
//        bottomSheetDialog.show();
//    }

    private void setRecyclerData() {
        List<Test> test = new ArrayList<>();
        test.add(new Test("Engine Oil Change"));
        test.add(new Test("Denting & Painting"));
        test.add(new Test("Denting & Painting"));
        test.add(new Test("Denting & Painting"));

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
