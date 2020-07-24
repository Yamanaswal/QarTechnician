package com.app.qartechnician.fragments.home_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class AppointmentsFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TabLayout tab_layout;
    private ViewPager view_pager;
    ViewPagerAdapter viewPagerAdapter;

    private Toolbar toolbar;
    private TextView bar_text;
    ImageView back_button;

    public AppointmentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_appointments, container, false);
        setIds();
        setData();
        return view;
    }

    private void setIds() {
        tab_layout = view.findViewById(R.id.tab_layout);
        view_pager = view.findViewById(R.id.view_pager);
        toolbar = view.findViewById(R.id.toolbar);
        bar_text = toolbar.findViewById(R.id.bar_text);
        back_button = toolbar.findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
    }

    private void setData() {
        //setting Customize Toolbar
        bar_text.setText(R.string.my_appointments);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        if (isAdded()) {
            setTabLayout();
        }
    }

    private void setTabLayout() {
        viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        tab_layout.setupWithViewPager(view_pager);
        view_pager.setAdapter(viewPagerAdapter);


        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                break;
        }

    }
}
