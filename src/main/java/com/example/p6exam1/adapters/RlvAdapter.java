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
import com.example.p6exam1.beans.NavBean;

import java.util.ArrayList;

public class RlvAdapter extends RecyclerView.Adapter {

    private ArrayList<NavBean.NewsBean> navlist;
    private Context context;

    public RlvAdapter(ArrayList<NavBean.NewsBean> navlist, Context context) {
        this.navlist = navlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rlv_item1_items, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 viewHolder1 = (ViewHolder1) holder;
        viewHolder1.txt_1.setText(navlist.get(position).getTile());
        viewHolder1.txt_2.setText(navlist.get(position).getContent());
        Glide.with(context).load(navlist.get(position).getImageUrl()).into(viewHolder1.img);
    }

    @Override
    public int getItemCount() {
        return navlist.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt_1;
        TextView txt_2;
        public ViewHolder1(View view) {
            super(view);
            img = view.findViewById(R.id.img);
            txt_1 = view.findViewById(R.id.txt_1);
            txt_2 = view.findViewById(R.id.txt_2);
        }
    }
}
