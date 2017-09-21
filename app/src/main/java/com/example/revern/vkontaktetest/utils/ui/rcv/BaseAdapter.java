package com.example.revern.vkontaktetest.utils.ui.rcv;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Func1;

/**
 * Created by Revern on 23.08.2017.
 */

public class BaseAdapter<T, VH extends BaseHolder<T>> extends RecyclerView.Adapter<VH> {

    @NonNull private List<T>              items;
    @NonNull private Func1<ViewGroup, VH> func;

    @Nullable private OnItemClickListener<T> onItemClickListener;

    public BaseAdapter(@NonNull List<T> items, @NonNull Func1<ViewGroup, VH> func,
                       @Nullable OnItemClickListener<T> onItemClickListener) {
        this.items = items;
        this.func = func;
        this.onItemClickListener = onItemClickListener;
        List<String> lista = new ArrayList<>();
        Log.d("base_adapter", "constructor");
    }

    @Override public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("base_adapter", "onCreateViewHolder");
        VH holder = func.call(parent);
        holder.itemView.setOnClickListener(v -> {
            int position = holder.getAdapterPosition();
            if(position != RecyclerView.NO_POSITION && onItemClickListener != null) {
                onItemClickListener.onItemClick(items.get(position));
            }
        });
        return holder;
    }

    @Override public void onBindViewHolder(VH holder, int position) {

        holder.bind(items.get(position));
    }

    @Override public int getItemCount() {
        return items.size();
    }

    @NonNull public List<T> getItems() {
        return items;
    }

    public void addItem(@NonNull T item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    public void addItems(@NonNull List<T> items) {
        int oldSize = this.items.size();
        this.items.addAll(items);
        notifyItemRangeInserted(oldSize, items.size());
    }

    public void setItems(@NonNull List<T> items) {
        this.items=items;
        notifyDataSetChanged();
    }

}