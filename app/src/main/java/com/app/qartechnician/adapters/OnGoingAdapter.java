package com.app.qartechnician.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.Test;
import com.app.qartechnician.screens.CreateInspectionReportActivity;
import com.app.qartechnician.screens.QuotationActivity;

import java.util.List;

public class OnGoingAdapter extends RecyclerView.Adapter<OnGoingAdapter.ViewHolder> {

    Context context;
    List<Test> list;

    public OnGoingAdapter(Context context, List<Test> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OnGoingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.on_going_item, parent, false);
        return new OnGoingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnGoingAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout quotations;
        TextView create;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quotations = itemView.findViewById(R.id.relative_one);
            create = itemView.findViewById(R.id.create);

            create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, CreateInspectionReportActivity.class));
                }
            });

            quotations.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, QuotationActivity.class));
                }
            });
        }
    }
}
