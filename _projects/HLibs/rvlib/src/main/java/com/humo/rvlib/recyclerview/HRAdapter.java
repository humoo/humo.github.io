package com.humo.rvlib.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView 基础适配器
 * Created by Humo on 2017/12/4 18:26.
 */

public abstract class HRAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List data = new ArrayList<>();
    private int selectedP = -1;

    public HRAdapter() {
    }

    public void addMore(List data) {
        if (data != null) {
            this.data = data;
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (data != null) {
            data.clear();
            notifyDataSetChanged();
        }
    }

    public void setSelected(int position) {
        selectedP = position;
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((HRViewHolder) holder).bindData(data.get(position), position, selectedP);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public abstract HRViewHolder getHolder(ViewGroup parent);
}
