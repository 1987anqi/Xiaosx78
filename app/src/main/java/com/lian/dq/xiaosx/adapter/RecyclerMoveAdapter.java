package com.lian.dq.xiaosx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lian.dq.xiaosx.R;
import com.lian.dq.xiaosx.mvp.view.OnItemMoveListener;

import java.util.Collections;
import java.util.List;

public class RecyclerMoveAdapter extends RecyclerView.Adapter implements OnItemMoveListener {
    private List<String> list;
    private Context mContext;
    private LayoutInflater inflater;
    public RecyclerMoveAdapter(Context mContext) {
        this.mContext = mContext;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fenitem, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.bt.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(list, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        list.remove(position);
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private Button bt;

        public MyViewHolder(View itemView) {
            super(itemView);
            bt = (Button) itemView.findViewById(R.id.btb);
        }
    }
}
