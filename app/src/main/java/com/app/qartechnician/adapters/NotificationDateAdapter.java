package com.app.qartechnician.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.Test;

import java.util.ArrayList;
import java.util.List;

public class NotificationDateAdapter  extends RecyclerView.Adapter<NotificationDateAdapter.ViewHolder> {

    private Context context;
    private List<Test> list;

    public NotificationDateAdapter(Context context, List<Test> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NotificationDateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.date_item, parent, false);
        return new NotificationDateAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            setRecyclerData();
        }

        private void setRecyclerData() {
            List<Test> test = new ArrayList<>();
            test.add(new Test("Engine Oil Change"));
            test.add(new Test("Denting & Painting"));
            test.add(new Test("AC Gas Topup"));

            NotificationsAdapter adapter = new NotificationsAdapter(context,test);
            recyclerView.setAdapter(adapter);
        }
    }
}
