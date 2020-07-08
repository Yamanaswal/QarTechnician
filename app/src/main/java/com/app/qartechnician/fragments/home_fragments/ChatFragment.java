package com.app.qartechnician.fragments.home_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.adapters.ChatAdapter;
import com.app.qartechnician.models.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment implements View.OnClickListener {

    private View view;
    private RecyclerView recyclerView;
    ImageView sent_button;
    EditText chat_edit_text;

    Toolbar toolbar;
    TextView bar_text;
    ImageView back_button;

    private List<Test> test = new ArrayList<>();

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
        sent_button = view.findViewById(R.id.sent_button);
        chat_edit_text = view.findViewById(R.id.chat_edit_text);

        toolbar = view.findViewById(R.id.toolbar);
        bar_text = toolbar.findViewById(R.id.bar_text);
        back_button = toolbar.findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
        sent_button.setOnClickListener(this);
    }

    private void setData() {
        //setting Customize Toolbar
        bar_text.setText(R.string.chat_admin);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.back_button:
                break;

            case R.id.sent_button:
                String sender_msg = chat_edit_text.getText().toString();
                setRecyclerView(sender_msg);
                chat_edit_text.setText("");
                break;
        }
    }

    private void setRecyclerView(String sender_msg) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        test.add(new Test(sender_msg));
        ChatAdapter adapter = new ChatAdapter(getContext(),test);
        recyclerView.setAdapter(adapter);

    }
}
