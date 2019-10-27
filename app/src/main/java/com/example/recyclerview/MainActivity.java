package com.example.recyclerview;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.adapter.ItemArrayAdapter;
import com.example.recyclerview.model.DataClass;
import com.example.recyclerview.model.Item;
import com.example.recyclerview.pagenation.PaginationListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] images = DataClass.imageArray;

    // Initializing list view with the custom adapter
    ArrayList<Item> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initData() {
        // Populating list items
        for (int i = 0; i < 25; i++) {
            Uri uri = Uri.parse(images[i]);
            itemList.add(new Item("Name " + i,
                    "Description " + i + "\nSample Text"
                            + "\nSample Text", uri));
        }
    }

    private void initRecyclerView() {
        final ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter();
        recyclerView = findViewById(R.id.item_list);
        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);
        initData();
        itemArrayAdapter.addItems(itemList);

        recyclerView.addOnScrollListener(new PaginationListener(layoutManager) {
            @Override
            protected void loadMoreItems() {
                itemArrayAdapter.addItems(itemList);
            }
        });
    }
}