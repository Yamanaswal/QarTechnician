package com.app.qartechnician.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.Test;

import java.util.List;

public class ManageDatesAdapter extends RecyclerView.Adapter<ManageDatesAdapter.ViewHolder> {

    private Context context;
    private List<Test> list;

    public ManageDatesAdapter(Context context, List<Test> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ManageDatesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.manage_date_item, parent, false);
        return new ManageDatesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
