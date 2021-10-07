package com.example.restapi.adapter;

/**
 * Created by Md Minhajul Islam on 10/7/2021.
 */
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.restapi.databinding.ContinentalRowBinding;
import com.example.restapi.model.DemoSubModel;

import java.util.List;

/**
 * Created by Md Minhajul Islam on 10/6/2021.
 */
public class ContinentsAdapter extends RecyclerView.Adapter<ContinentsAdapter.ViewHolder> {
    private List<DemoSubModel> objectDataClasses;


    public void updateBaseData(List<DemoSubModel> objectDataClasses){
        this.objectDataClasses = objectDataClasses;
    }

    @NonNull
    @Override
    public ContinentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContinentalRowBinding rowBinding = ContinentalRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        return new ViewHolder(rowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentsAdapter.ViewHolder holder, int position) {
        DemoSubModel objectData = objectDataClasses.get(position);
        holder.bindView(objectData);
    }

    @Override
    public int getItemCount() {
        return objectDataClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ContinentalRowBinding rowBinding;
        public ViewHolder(@NonNull ContinentalRowBinding rowBinding) {
            super(rowBinding.getRoot());
            this.rowBinding = rowBinding;
        }

        public void bindView(DemoSubModel objectData) {
            rowBinding.setRow(objectData);
        }
    }
}

