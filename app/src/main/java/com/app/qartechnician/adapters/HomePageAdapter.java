package com.app.qartechnician.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.Test;
import com.app.qartechnician.screens.ReasonRejectActivity;

import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.ViewHolder>  {

    Context context;
    List<Test> list;

    public HomePageAdapter(Context context, List<Test> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_page_item, parent, false);
        return new HomePageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView reject,confirm;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            reject = itemView.findViewById(R.id.reject);
            confirm = itemView.findViewById(R.id.confirm);

            reject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, ReasonRejectActivity.class));
                }
            });
        }
    }
}
