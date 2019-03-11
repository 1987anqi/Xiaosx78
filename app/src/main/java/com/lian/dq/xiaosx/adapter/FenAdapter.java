package com.lian.dq.xiaosx.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lian.dq.xiaosx.R;
import com.lian.dq.xiaosx.beans.Fen;

import java.util.List;

public class FenAdapter extends RecyclerView.Adapter<FenAdapter.ViewHolder> {

    private List<Fen.ClassifyBean> fenlist;
    private Context context;

    public FenAdapter(List<Fen.ClassifyBean> fenlist, Context context) {
        this.fenlist = fenlist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.fenitem,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.btb.setText(fenlist.get(i).getClassify_title());
    }

    @Override
    public int getItemCount() {
        return fenlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btb;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btb = itemView.findViewById(R.id.btb);
        }
    }
}
