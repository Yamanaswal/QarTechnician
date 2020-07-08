package com.app.qartechnician.fragments.home_fragments;

import android.app.Activity;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class AppointmentsFragment extends Fragment implements TabLayout.OnTabSelectedListener,View.OnClickListener {

    private View view;
    private TabLayout tab_layout;
    private ViewPager view_pager;

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
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        setTabLayout();
    }

    private void setTabLayout() {
        if (getFragmentManager() != null) {
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager(), tab_layout.getTabCount());
            view_pager.setAdapter(viewPagerAdapter);
        }

        //listener to Tab Layout
        tab_layout.addOnTabSelectedListener(this);
        view_pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onClick(View v) {

    }
}
