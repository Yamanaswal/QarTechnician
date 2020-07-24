package com.app.qartechnician.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.my_appointment.my_appointment_response.MyAppointmentResponseData;
import com.app.qartechnician.screens.CreateInspectionReportActivity;
import com.app.qartechnician.screens.QuotationActivity;
import com.bumptech.glide.Glide;

import java.util.List;

public class OnGoingAdapter extends RecyclerView.Adapter<OnGoingAdapter.ViewHolder> {

    Context context;
    List<MyAppointmentResponseData> list;

    public OnGoingAdapter(Context context, List<MyAppointmentResponseData> list) {
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

        holder.person_name.setText(list.get(position).getFullName());
        holder.car_type.setText(list.get(position).getCompanyName());
        holder.vehicle_no.setText("Vehicle No." + list.get(position).getVehicleNo());
        holder.car_service.setText(setServiceName(list.get(position).getServiceName()));
        holder.appoint_no.setText(context.getString(R.string.appoint_no_dash) + list.get(position).getOrderId());
        holder.date_and_time.setText(setBookingDate(list.get(position).getBookingTime(),list.get(position).getBookingDate()));
        if (!list.get(position).getModelImage().isEmpty() || list.get(position).getModelImage() != null) {
            Glide.with(context).load(list.get(position).getModelImage()).into(holder.modelImage);
        }

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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout quotations, call_button, chat_button;
        TextView create, person_name, car_type, vehicle_no, car_service, appoint_no, date_and_time,upload_image,raise_quots;
        ImageView modelImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quotations = itemView.findViewById(R.id.quotations);
            create = itemView.findViewById(R.id.create);
            person_name = itemView.findViewById(R.id.person_name);
            car_type = itemView.findViewById(R.id.car_type);
            vehicle_no = itemView.findViewById(R.id.vehicle_no);
            car_service = itemView.findViewById(R.id.car_service);
            appoint_no = itemView.findViewById(R.id.appoint_no);
            date_and_time = itemView.findViewById(R.id.date_and_time);
            modelImage = itemView.findViewById(R.id.modelImage);
            call_button = itemView.findViewById(R.id.call_button);
            chat_button = itemView.findViewById(R.id.chat_button);
            upload_image = itemView.findViewById(R.id.upload_image);
            raise_quots = itemView.findViewById(R.id.raise_quots);

            create.setOnClickListener(this);
            quotations.setOnClickListener(this);
            raise_quots.setOnClickListener(this);
            upload_image.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.create:
                    context.startActivity(new Intent(context, CreateInspectionReportActivity.class));
                    break;

                case R.id.quotations:
                    context.startActivity(new Intent(context, QuotationActivity.class));
                    break;

                case R.id.upload_image:
                    break;

                case R.id.raise_quots:
                    break;
            }
        }
    }
}
