package com.app.qartechnician.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.Test;

import java.util.List;

public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.ViewHolder> {

    private Context context;
    private List<Test> list;

    public WalletAdapter(Context context, List<Test> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public WalletAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wallet_item, parent, false);
        return new WalletAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WalletAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
