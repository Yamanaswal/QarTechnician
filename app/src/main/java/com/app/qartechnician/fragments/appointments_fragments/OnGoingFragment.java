package com.app.qartechnician.fragments.appointments_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.CancelledAdapter;
import com.app.qartechnician.adapters.OnGoingAdapter;
import com.app.qartechnician.models.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnGoingFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;

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
    }

    private void setData() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        setRecyclerData();
    }

    private void setRecyclerData() {
        List<Test> test = new ArrayList<>();
        test.add(new Test("Engine Oil Change"));

        OnGoingAdapter adapter = new OnGoingAdapter(getContext(),test);
        recyclerView.setAdapter(adapter);
    }
}
