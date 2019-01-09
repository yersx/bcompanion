package com.example.user.bcompanion3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class HorizontalItemsAdapter extends
        RecyclerView.Adapter<HorizontalItemsAdapter.HorizontalItemViewHolder>  {

    private List<String> mLabels;

    public HorizontalItemsAdapter(List<String> labels) {
        mLabels = labels;
    }

    @NonNull
    @Override
    public HorizontalItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_horizontal_item_list, viewGroup, false);

        return new HorizontalItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalItemViewHolder horizontalItemViewHolder, int i) {
        horizontalItemViewHolder.bindItem(mLabels.get(i));
    }

    @Override
    public int getItemCount() {
        return mLabels.size();
    }

    public class HorizontalItemViewHolder extends RecyclerView.ViewHolder {

        //private TextView mLabel;
        private ImageView mImageView;

        public HorizontalItemViewHolder(@NonNull View itemView) {
            super(itemView);

            //mLabel = itemView.findViewById(R.id.label);
            mImageView = itemView.findViewById(R.id.image);
        }

        public void bindItem(String item) {
            switch(item){
                case "0":
                    mImageView.setImageResource(R.drawable.bao1);
                    break;
                case "1":
                    mImageView.setImageResource(R.drawable.bao2);
                    break;
                case "2":
                    mImageView.setImageResource(R.drawable.bao3);
                    break;
                case "3":
                    mImageView.setImageResource(R.drawable.bao4);
                    break;
                case "4":
                    mImageView.setImageResource(R.drawable.bao5);
                    break;
                case "5":
                    mImageView.setImageResource(R.drawable.bao6);
                    break;
                case "6":
                    mImageView.setImageResource(R.drawable.bao7);
                    break;
                case "7":
                    mImageView.setImageResource(R.drawable.bao8);
                    break;
            }

//            mLabel.setText(item);
        }
    }
}
