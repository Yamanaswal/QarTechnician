package com.app.qartechnician.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;

import java.util.List;

public class EditProfileAdapter extends RecyclerView.Adapter<EditProfileAdapter.ViewHolder> {

    Context context;
    List<Bitmap> list;

    public EditProfileAdapter(Context context, List<Bitmap> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EditProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.profile_image_item, parent, false);
        return new EditProfileAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EditProfileAdapter.ViewHolder holder, int position) {

        holder.camera_view.setImageBitmap(list.get(position));

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView camera_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            camera_view = itemView.findViewById(R.id.camera_view);
        }
    }
}
