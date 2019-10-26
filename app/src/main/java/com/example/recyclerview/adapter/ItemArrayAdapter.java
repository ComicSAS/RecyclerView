package com.example.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerview.R;
import com.example.recyclerview.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemArrayAdapter extends RecyclerView.Adapter<ViewHolder> {
    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private ArrayList<Item> itemList;

    public ItemArrayAdapter() {
        this.itemList = new ArrayList<>();
    }

    // specify the row layout file and click for each row
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Item item = itemList.get(i);
        viewHolder.bindData(item);
    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    public void addItems(List<Item> items){
        if(items == null){
            return;
        }else if(items.isEmpty()){
            return;
        }else {
            itemList.addAll(items);
            //update state of list inside Adapter
            notifyDataSetChanged();
        }
    }
}
