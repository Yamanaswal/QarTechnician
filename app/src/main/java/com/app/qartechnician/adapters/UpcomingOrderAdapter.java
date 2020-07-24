package com.app.qartechnician.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.upcoming_order.upcoimg_order_response.UpcomingOrderResponseData;
import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        holder.car_service_name.setText(setServiceName(list.get(position).getServiceName()));
        holder.appoint_no.setText(context.getString(R.string.appoint_no_dash) + list.get(position).getOrderId());
        holder.car_colour.setText("Mark White");
        holder.car_type.setText(list.get(position).getCompanyName());
        holder.vehicle_no.setText("Vehicle No." + list.get(position).getVehicleNo());
        if (!list.get(position).getModelImage().isEmpty() || list.get(position).getModelImage() != null) {
            Glide.with(context).load(list.get(position).getModelImage()).into(holder.circle_image);
        }

        holder.date_and_time.setText(setBookingDate(list.get(position).getBookingTime(),list.get(position).getBookingDate()));

    }

    private String setBookingDate(String bookingTime, String bookingDate) {
        String[] bookingTimeArr = bookingTime.split("-");
        String bookingTimeRes = bookingTimeArr[0] + " To " + bookingTimeArr[1];

        String booking = bookingDate.substring(0,10);

        return booking + "," +bookingTimeRes;
    }

    private String setServiceName(List<String> serviceName) {
        StringBuilder serviceNames = new StringBuilder();

        for (String s : serviceName) {
            serviceNames.append(s + "\n");
        }

        return serviceNames.toString();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView car_service_name, car_colour, car_type, vehicle_no, appoint_no, date_and_time;
        ImageView circle_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            car_service_name = itemView.findViewById(R.id.car_service_name);
            car_colour = itemView.findViewById(R.id.car_colour);
            car_type = itemView.findViewById(R.id.car_type);
            vehicle_no = itemView.findViewById(R.id.vehicle_no);
            appoint_no = itemView.findViewById(R.id.appoint_no);
            date_and_time = itemView.findViewById(R.id.date_and_time);
            circle_image = itemView.findViewById(R.id.circle_image);
        }
    }
}
