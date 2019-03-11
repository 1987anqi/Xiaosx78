package com.lian.dq.xiaosx.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lian.dq.xiaosx.R;
import com.lian.dq.xiaosx.beans.ListDemo;

import java.util.List;

public class YaowenAdpter extends RecyclerView.Adapter<YaowenAdpter.ViewHolder> {

    List<ListDemo.ImageListBean> listBeans;
    Context context;

    public YaowenAdpter(List<ListDemo.ImageListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.yaowenitem,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(listBeans.get(i).getImage_url()).into(viewHolder.img);
        viewHolder.info.setText(listBeans.get(i).getImage_content());
        viewHolder.time.setText(listBeans.get(i).getTime_date());
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView info;
        TextView time;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            info = itemView.findViewById(R.id.info);
            time = itemView.findViewById(R.id.time);
            img = itemView.findViewById(R.id.img);
        }
    }
}
