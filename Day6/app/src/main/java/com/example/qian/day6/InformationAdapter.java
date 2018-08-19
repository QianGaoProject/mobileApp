package com.example.qian.day6;


import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.OneItemViewHolder> {
    private List<Information> myList;

    public InformationAdapter(List<Information> list){
        myList = list;
    }
    @NonNull
    @Override

    public InformationAdapter.OneItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View inflatedView=inflater.inflate(R.layout.per_item_view,viewGroup,false);
        return new OneItemViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull InformationAdapter.OneItemViewHolder oneItemViewHolder, final int position) {
         oneItemViewHolder.tvInOneItem.setText(position+" "+myList.get(position).getName()+" "+myList.get(position).getAddress()+" "+
                 myList.get(position).getPhone());
         oneItemViewHolder.singleItemParentLayout.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View view){
                 Log.d("RecyclerView","Click card number: "+Integer.toString(position));
             }
         });
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
    class OneItemViewHolder extends RecyclerView.ViewHolder{
        TextView tvInOneItem;
        FrameLayout singleItemParentLayout;
        public OneItemViewHolder(@NonNull View itemView){
            super(itemView);
            tvInOneItem=itemView.findViewById(R.id.tv_in_item);
            singleItemParentLayout=itemView.findViewById(R.id.single_item_parent_layout);
        }
    }
}