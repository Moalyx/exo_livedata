package com.tuto.taffmediator.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuto.taffmediator.R;
import com.tuto.taffmediator.data.Item;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Item> itemList;
    Context context;

    public MyAdapter(List<Item> itemList, Context context){
        this.itemList = itemList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.name.setText(item.getName());
        holder.unitprice.setText(item.getUnitPrice());
        holder.quantity.setText(item.getQuantity());
        holder.totalprice.setText(item.getTotal());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name = itemView.findViewById(R.id.name);
        TextView unitprice = itemView.findViewById(R.id.unitprice);
        TextView quantity = itemView.findViewById(R.id.quantity);
        TextView totalprice = itemView.findViewById(R.id.totalprice);

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


        }
    }
}
