package com.jowney.database.adapter;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jowney.database.R;
import com.jowney.database.bean.Student;

import java.security.PublicKey;
import java.util.List;

/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/5/14/22:38
 * Description:
 */

public class RecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerAdapter<T>.ViewHolder>{

    private List<T> data;

    public RecyclerAdapter(List<T> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_adapter_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( RecyclerAdapter<T>.ViewHolder holder, int position) {
        holder.textView.setText(data.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

         ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
