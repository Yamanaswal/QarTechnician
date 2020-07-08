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

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private Context context;
    private List<Test> list;

    public ChatAdapter(Context context, List<Test> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chat_sender,parent,false);
        return new ChatAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder holder, int position) {
        holder.chat_message.setText(list.get(position).getService_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView chat_message,chat_date;
        CircleImageView profile_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chat_message = itemView.findViewById(R.id.chat_message);
            chat_date = itemView.findViewById(R.id.chat_date);
            profile_image = itemView.findViewById(R.id.profile_image);
        }
    }
}
