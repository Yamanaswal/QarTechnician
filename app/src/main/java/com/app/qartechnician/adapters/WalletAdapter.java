package com.app.qartechnician.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.garage_money.garage_money_response.GarageMoneyResponseDataList;

import java.util.List;

public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.ViewHolder> {

    private Context context;
    private List<GarageMoneyResponseDataList> list;

    public WalletAdapter(Context context, List<GarageMoneyResponseDataList> list) {
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
        holder.wallet_status.setText(setServiceName(list.get(position).getBooking().getServiceName()));
        holder.wallet_amount.setText((int) list.get(position).getWallet().getAmount() + " QAR");
        holder.wallet_time.setText(setTime(list.get(position).getWallet().getCreatedAt()));
    }

    private String setServiceName(List<String> serviceName) {
        StringBuilder serviceNames = new StringBuilder();
        for (String s : serviceName) {
            serviceNames.append(s + "\n");
        }
        return serviceNames.toString();
    }

    private String setTime(String createdAt) {
        return createdAt;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


//    @Override
//    public int getItemViewType(int position) {
//        if () {
//            return WALLET_DATE;
//        } else {
//
//        }
//        return -1;
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView wallet_status, wallet_time, wallet_amount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            wallet_status = itemView.findViewById(R.id.wallet_status);
            wallet_time = itemView.findViewById(R.id.wallet_time);
            wallet_amount = itemView.findViewById(R.id.wallet_amount);
        }
    }
}
