package com.app.qartechnician.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.Test;
import com.app.qartechnician.utils.CommonUtils;

import java.util.List;

public class OngoingOrderAdapter extends RecyclerView.Adapter<OngoingOrderAdapter.ViewHolder> {

    Context context;
    List<Test> list;

    public OngoingOrderAdapter(Context context, List<Test> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ongoing_order_item, parent, false);
        return new OngoingOrderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Test test = list.get(position);

        holder.car_service_name.setText(test.getService_name());

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, position + "", Toast.LENGTH_SHORT).show();
                CommonUtils.callMobileNumber(context,"0123456789");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView car_service_name, car_colour, car_type, vehicle_no, appoint_no, date_and_time;
        RelativeLayout update_status,call,chat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            car_service_name = itemView.findViewById(R.id.car_service_name);
            car_colour = itemView.findViewById(R.id.car_colour);
            car_type = itemView.findViewById(R.id.car_type);
            vehicle_no = itemView.findViewById(R.id.vehicle_no);
            appoint_no = itemView.findViewById(R.id.appoint_no);
            date_and_time = itemView.findViewById(R.id.date_and_time);
            update_status = itemView.findViewById(R.id.update_status);
            call = itemView.findViewById(R.id.call);
            chat = itemView.findViewById(R.id.chat);
        }
    }
}
