package com.app.qartechnician.fragments.home_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.ChatPeopleAdapter;
import com.app.qartechnician.screens.ChatAdminActivity;

public class ChatFragment extends Fragment implements View.OnClickListener {

    private View view;
    private RecyclerView recyclerView;

    Toolbar toolbar;
    TextView bar_text;
    ImageView help_button;


    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_chat, container, false);
        setIds();
        setData();
        return view;
    }


    private void setIds() {
        recyclerView = view.findViewById(R.id.recycler_view);
        help_button = view.findViewById(R.id.help_button);
        toolbar = view.findViewById(R.id.toolbar);
        bar_text = toolbar.findViewById(R.id.bar_text);
        help_button.setOnClickListener(this);
    }

    private void setData() {
        //setting Customize Toolbar
        bar_text.setText(R.string.chats);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        setRecyclerView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.help_button:
                startActivity(new Intent(getContext(), ChatAdminActivity.class));
                break;
        }
    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ChatPeopleAdapter adapter = new ChatPeopleAdapter();
        recyclerView.setAdapter(adapter);
    }
}
