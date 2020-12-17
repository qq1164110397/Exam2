package com.example.p6exam1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.p6exam1.R;
import com.example.p6exam1.beans.ClassBean;

import java.util.ArrayList;

public class RlvAdapter2 extends RecyclerView.Adapter {

    private ArrayList<ClassBean.StudenlistBean> classlist;
    private Context context;

    public RlvAdapter2(ArrayList<ClassBean.StudenlistBean> classlist, Context context) {
        this.classlist = classlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rlv_item2_items, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 viewHolder1 = (ViewHolder1) holder;
        viewHolder1.tv_name.setText(classlist.get(position).getName());
        viewHolder1.tv_js.setText(classlist.get(position).getSkill());
        viewHolder1.tv_ll.setText(classlist.get(position).getTheory());
    }

    @Override
    public int getItemCount() {
        return classlist.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_js;
        TextView tv_ll;
        public ViewHolder1(View view) {
            super(view);
            tv_name = view.findViewById(R.id.tv_name);
            tv_js = view.findViewById(R.id.tv_js);
            tv_ll = view.findViewById(R.id.tv_ll);
        }
    }
}
