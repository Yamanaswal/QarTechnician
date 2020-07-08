package com.app.qartechnician.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.app.qartechnician.fragments.appointments_fragments.CancelledFragment;
import com.app.qartechnician.fragments.appointments_fragments.CompletedFragment;
import com.app.qartechnician.fragments.appointments_fragments.OnGoingFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm, numOfTabs);
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new OnGoingFragment();
                break;
            case 1:
                fragment = new CompletedFragment();
                break;
            case 2:
                fragment = new CancelledFragment();
                break;
        }
         return fragment;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
