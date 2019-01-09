package com.example.user.bcompanion3;

import java.util.List;

public class Item {
    private List<String> mItems;

    public Item( List<String> items) {

        mItems = items;
    }


    public List<String> getItems() {
        return mItems;
    }

    public void setItems(List<String> items) {
        mItems = items;
    }

    @Override
    public String toString() {
        return "Item{" +
                "mItems=" + mItems +
                '}';
    }
}
