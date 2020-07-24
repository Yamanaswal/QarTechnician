package com.app.qartechnician.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.my_appointment.my_appointment_response.MyAppointmentResponseData;
import com.app.qartechnician.utils.CommonUtils;
import com.bumptech.glide.Glide;

import java.util.List;

public class CancelledAdapter extends RecyclerView.Adapter<CancelledAdapter.ViewHolder> {

    Context context;
    List<MyAppointmentResponseData> list;

    public CancelledAdapter(Context context, List<MyAppointmentResponseData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CancelledAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cancelled_item, parent, false);
        return new CancelledAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CancelledAdapter.ViewHolder holder, int position) {
        holder.appoint_no.setText(context.getResources().getString(R.string.appoint_no_dash) + list.get(position).getOrderId());
        holder.pay_mode.setText(list.get(position).getModeOfPayment());
        holder.car_service.setText(setServiceName(list.get(position).getServiceName()));
        holder.reason_text.setText(list.get(position).getReason());
        holder.car_model.setText(list.get(position).getCompanyName());
        holder.person_name.setText(list.get(position).getFullName());
        holder.vehicle_no.setText(context.getResources().getString(R.string.vehicle_no) + " " + list.get(position).getVehicleNo());
        holder.date_and_time.setText(CommonUtils.convertTimeStampToDate(list.get(position).getBookingDate()) + ","
                + getBookedTime(list.get(position).getBookingFormTime(), list.get(position).getBookingToTime()));
        holder.booked_date.setText(CommonUtils.convertTimeStampToDate(list.get(position).getCreatedAt()));
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

        TextView appoint_no, date_and_time,car_service, reason_text, car_model, person_name, vehicle_no, booked_date, pay_mode;
        ImageView car_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            appoint_no = itemView.findViewById(R.id.appoint_no);
            date_and_time = itemView.findViewById(R.id.date_and_time);
            car_service = itemView.findViewById(R.id.car_service);
            reason_text = itemView.findViewById(R.id.reason_text);
            car_model = itemView.findViewById(R.id.car_model);
            person_name = itemView.findViewById(R.id.person_name);
            vehicle_no = itemView.findViewById(R.id.vehicle_no);
            booked_date = itemView.findViewById(R.id.booked_date);
            pay_mode = itemView.findViewById(R.id.pay_mode);
            car_image = itemView.findViewById(R.id.car_image);

        }
    }
}
