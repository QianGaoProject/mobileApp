package com.example.qian.retrofitclient;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class TesterAdapter extends RecyclerView.Adapter<TesterAdapter.OneItemViewHolder> {
    private List<GitHubRepo> list;

    public TesterAdapter(List<GitHubRepo> list){
        this.list = list;
    }
    @NonNull
    @Override

    public TesterAdapter.OneItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View inflatedView=inflater.inflate(R.layout.per_item_history,viewGroup,false);
        return new OneItemViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull TesterAdapter.OneItemViewHolder oneItemViewHolder, final int position) {
        oneItemViewHolder.tvInOneItem.setText(position+" "+list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
    class OneItemViewHolder extends RecyclerView.ViewHolder{
        TextView tvInOneItem;
        public OneItemViewHolder(@NonNull View itemView){
            super(itemView);
            tvInOneItem=itemView.findViewById(R.id.tv_in_item);
        }
    }
}