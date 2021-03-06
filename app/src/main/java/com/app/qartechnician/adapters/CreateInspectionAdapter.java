package com.app.qartechnician.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.qartechnician.R;
import com.app.qartechnician.models.Test;

import java.util.List;

public class CreateInspectionAdapter extends RecyclerView.Adapter<CreateInspectionAdapter.ViewHolder> {

    private Context context;
    private List<Test> list;

    public CreateInspectionAdapter(Context context, List<Test> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CreateInspectionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.inspection_item, parent, false);
        return new CreateInspectionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreateInspectionAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Spinner spinner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            spinner = itemView.findViewById(R.id.spinner);
            setSpinner();
        }

        private void setSpinner() {
            ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(context,R.array.job_update,android.R.layout.simple_spinner_item);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            spinner.setAdapter(arrayAdapter);
        }
    }
}
