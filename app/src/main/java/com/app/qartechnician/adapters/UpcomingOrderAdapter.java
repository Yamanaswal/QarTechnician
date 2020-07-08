package com.app.qartechnician.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.Test;
import com.app.qartechnician.models.upcoming_order.upcoimg_order_response.UpcomingOrderResponseData;

import java.util.List;

public class UpcomingOrderAdapter extends RecyclerView.Adapter<UpcomingOrderAdapter.ViewHolder> {

    Context context;
    List<UpcomingOrderResponseData> list;

    public UpcomingOrderAdapter(Context context, List<UpcomingOrderResponseData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.upcoming_order_item, parent, false);
        return new UpcomingOrderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingOrderAdapter.ViewHolder holder, int position) {
        holder.car_service_name.setText("New Car");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView car_service_name, car_colour, car_type, vehicle_no, appoint_no, date_and_time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            car_service_name = itemView.findViewById(R.id.car_service_name);
            car_colour = itemView.findViewById(R.id.car_colour);
            car_type = itemView.findViewById(R.id.car_type);
            vehicle_no = itemView.findViewById(R.id.vehicle_no);
            appoint_no = itemView.findViewById(R.id.appoint_no);
            date_and_time = itemView.findViewById(R.id.date_and_time);
        }
    }
}
