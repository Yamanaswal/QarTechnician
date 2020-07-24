package com.app.qartechnician.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.my_appointment.my_appointment_response.MyAppointmentResponseData;
import com.app.qartechnician.screens.OrderDetailsActivity;
import com.app.qartechnician.utils.CommonUtils;
import com.bumptech.glide.Glide;

import java.util.List;

public class CompletedAdapter extends RecyclerView.Adapter<CompletedAdapter.ViewHolder> {

    Context context;
    List<MyAppointmentResponseData> list;

    public CompletedAdapter(Context context, List<MyAppointmentResponseData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CompletedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.completed_item, parent, false);
        return new CompletedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompletedAdapter.ViewHolder holder, int position) {

        holder.appoint_no.setText(context.getResources().getString(R.string.appoint_no_dash) + list.get(position).getOrderId());
        holder.car_service.setText(setServiceName(list.get(position).getServiceName()));
        holder.car_model.setText(list.get(position).getCompanyName());
        holder.person_name.setText(list.get(position).getFullName());
        holder.vehicle_no.setText(context.getResources().getString(R.string.vehicle_no) + " " + list.get(position).getVehicleNo());
        holder.date_and_time.setText(CommonUtils.convertTimeStampToDate(list.get(position).getBookingDate()) + ","
                + getBookedTime(list.get(position).getBookingFormTime(), list.get(position).getBookingToTime()));
        holder.price.setText(list.get(position).getTotalFee() + context.getResources().getString(R.string.qar));

        if (list.get(position).getModelImage() != null) {
            Glide.with(context).load(list.get(position).getModelImage()).into(holder.car_image);
        } else {
            holder.car_image.setImageResource(R.drawable.circle_background_orange);
        }

    }

    private String getBookedTime(String fromTime, String toTime) {
        return fromTime + " to " + toTime;
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

        TextView appoint_no, date_and_time, price, garage_address, garage_name, view_job_details, car_service, car_model, person_name, vehicle_no;
        ImageView car_image, car_image_two;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            appoint_no = itemView.findViewById(R.id.appoint_no);
            date_and_time = itemView.findViewById(R.id.date_and_time);
            car_service = itemView.findViewById(R.id.car_service);
            car_model = itemView.findViewById(R.id.car_model);
            person_name = itemView.findViewById(R.id.person_name);
            vehicle_no = itemView.findViewById(R.id.vehicle_no);
            car_image = itemView.findViewById(R.id.car_image);

            price = itemView.findViewById(R.id.price);
            garage_address = itemView.findViewById(R.id.garage_address);
            garage_name = itemView.findViewById(R.id.garage_name);
            view_job_details = itemView.findViewById(R.id.view_job_details);
            car_image_two = itemView.findViewById(R.id.car_image_two);

            view_job_details.setOnClickListener(v -> {
                Intent intent = new Intent(context, OrderDetailsActivity.class);
                intent.putExtra("bookingId", list.get(getAdapterPosition()).get_id());
                context.startActivity(intent);
            });

        }

    }
}
