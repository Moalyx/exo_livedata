package com.tuto.taffmediator.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tuto.taffmediator.R;
import com.tuto.taffmediator.data.Item;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ListAdapter<ItemViewState, MyAdapter.MyViewHolder> {

    private final OnItemClickedListener listener;


    public MyAdapter(OnItemClickedListener listener) {
        super(new ItemCallback());
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(getItem(position), listener);

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView unitprice;
        TextView quantity;
        TextView totalprice;
        ImageView delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            unitprice = itemView.findViewById(R.id.unitprice);
            quantity = itemView.findViewById(R.id.quantity);
            totalprice = itemView.findViewById(R.id.totalprice);
            delete = itemView.findViewById(R.id.delete);

        }

        public void onBind(ItemViewState itemViewState, OnItemClickedListener listener) {
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onDeleteItemClicked(itemViewState.getName());
                }
            });
            name.setText(itemViewState.getName());
            unitprice.setText(itemViewState.getUnitPrice());
            quantity.setText(itemViewState.getQuantity());
            totalprice.setText(itemViewState.getTotal());

        }
    }

    private static class ItemCallback extends DiffUtil.ItemCallback<ItemViewState> {

        @Override
        public boolean areItemsTheSame(@NonNull ItemViewState oldItem, @NonNull ItemViewState newItem) {
            return oldItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull ItemViewState oldItem, @NonNull ItemViewState newItem) {
            return oldItem.equals(newItem);
        }
    }
}
