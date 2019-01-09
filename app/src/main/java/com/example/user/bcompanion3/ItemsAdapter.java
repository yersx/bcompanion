package com.example.user.bcompanion3;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<Item> mItems;

    public ItemsAdapter(List<Item> items) {
        mItems = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_list,
                viewGroup, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.bindItem(mItems.get(i));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView mItemsView;

        private HorizontalItemsAdapter mAdapter;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            mItemsView = itemView.findViewById(R.id.inner_items_list);
        }

        public void bindItem(Item item) {

            mItemsView.setLayoutManager(new LinearLayoutManager(itemView.getContext(),
                    LinearLayoutManager.HORIZONTAL, false));

            mAdapter = new HorizontalItemsAdapter(item.getItems());
            mItemsView.setAdapter(mAdapter);
        }
    }
}
