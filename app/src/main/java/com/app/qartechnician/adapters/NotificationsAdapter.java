package com.app.qartechnician.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.notifications.notification_response.NotificationResponseData;
import com.app.qartechnician.utils.CommonUtils;

import java.util.List;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.ViewHolder> {

    Context context;
    List<NotificationResponseData> list;

    public NotificationsAdapter(Context context, List<NotificationResponseData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notifications_item, parent, false);
        return new NotificationsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.booking_confirm_text.setText(list.get(position).getMessage());
        holder.booking_time.setText(CommonUtils.convertTimeStampToTime(list.get(position).getCreatedAt()));
        holder.date.setText(CommonUtils.convertTimeStampToDate(list.get(position).getCreatedAt()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView booking_confirm_text, booking_time, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            booking_confirm_text = itemView.findViewById(R.id.booking_confirm_text);
            booking_time = itemView.findViewById(R.id.booking_time);
            date = itemView.findViewById(R.id.booked_date);
        }
    }
}
