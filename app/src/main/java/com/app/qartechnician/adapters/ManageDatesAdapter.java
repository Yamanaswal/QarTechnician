package com.app.qartechnician.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.Test;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class ManageDatesAdapter extends RecyclerView.Adapter<ManageDatesAdapter.ViewHolder> {

    private Context context;
    private List<Test> list;

    public ManageDatesAdapter(Context context, List<Test> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ManageDatesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.manage_date_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView pref_time_text_view;
        EditText pref_time_edit_text;
        CardView manage_card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            manage_card = itemView.findViewById(R.id.manage_card);
            pref_time_text_view = itemView.findViewById(R.id.pref_time_text_view);
            pref_time_edit_text = itemView.findViewById(R.id.pref_time_edit_text);
            manage_card.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.manage_card:
                    setBottomDialog();
                    break;
            }
        }


    }

    private void setBottomDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.AppBottomSheetDialogTheme);
        bottomSheetDialog.setContentView(R.layout.bottom_dialog);
        bottomSheetDialog.setCancelable(true);

        Spinner spinner = bottomSheetDialog.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(context, R.array.service_required, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        bottomSheetDialog.show();
    }
}
