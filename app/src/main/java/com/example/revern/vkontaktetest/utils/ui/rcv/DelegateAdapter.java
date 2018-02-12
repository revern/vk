package com.example.revern.vkontaktetest.utils.ui.rcv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Revern on 19.10.2017.
 */

public class DelegateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @NonNull private List<Object> items;
    @NonNull private Delegates delegates;

    public DelegateAdapter() {
        items = new ArrayList<>();
        delegates = new Delegates();
    }

    public DelegateAdapter(@NonNull List<Object> items) {
        super();
    }

    public <T> void addDelegate(@NonNull Class<? extends T> clazz,
                                @NonNull BaseHolder<T> holder) {
        delegates.addDelegate(clazz, holder);
    }

    public void removeDelegate(@NonNull Class<?> clazz) {
        delegates.removeDelegate(clazz);
    }

    public void removeAllDeleages() {
        delegates.removeAllDeleages();
    }

    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegates.getHolder(viewType);
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BaseHolder) {
            BaseHolder baseHolder = (BaseHolder) holder;
            baseHolder.bind(items.get(position));
        }
    }

    @Override public int getItemCount() {
        return items.size();
    }

    @Override public int getItemViewType(int position) {
        return delegates.getClazzPosition(items.get(position).getClass());
    }

    @NonNull public List<?> getItems() {
        return items;
    }

    public void addItem(@NonNull Object item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    public void addItems(@NonNull List<Object> items) {
        int oldSize = this.items.size();
        this.items.addAll(items);
        notifyItemRangeInserted(oldSize, items.size());
    }

    public void setItems(@NonNull List<Object> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}
