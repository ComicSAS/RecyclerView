package com.example.recyclerview.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recyclerview.R;
import com.example.recyclerview.model.Item;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView tvName, tvDescription;
    public ImageView ivItem;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        tvName = itemView.findViewById(R.id.tvName);
        tvDescription = itemView.findViewById(R.id.tvDescription);
        ivItem = itemView.findViewById(R.id.ivItem);
    }

    @Override
    public void onClick(View v) {
        Log.d("onclick", "onClick " + getLayoutPosition() + " " + tvName.getText()
                + " " + tvDescription.getText());
    }

    public void bindData(Item item) {
        tvName.setText(item.getName());
        tvDescription.setText(item.getDescription());
        Glide.with(itemView.getContext()).load(item.getImage()).circleCrop()
                .apply(RequestOptions.circleCropTransform()).dontAnimate().into(ivItem);
    }
}