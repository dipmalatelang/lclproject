package com.example.lcl.base;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.lcl.App;
import com.example.lcl.R;

import java.util.List;

public class BindingAdapters {

    @SuppressWarnings({"unchecked", "rawtypes"})
    @BindingAdapter(value = {"layoutFile", "listener", "listData"}, requireAll = false)
    public static <E> void bindAdapter(RecyclerView recyclerView, int id, BaseInterface listener, List<E> list) {
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new BaseAdapter(list, id, listener));
        } else {
            ((BaseAdapter) recyclerView.getAdapter()).setListener(listener);
            ((BaseAdapter) recyclerView.getAdapter()).setData(list);
        }
    }

    @BindingAdapter({"bind:playerImageUrl"})
    public static void loadPlayerImage(ImageView imageView, String imageUrl) {
        Glide.with(App.getAppContext())
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.drawable.ic_all_rounder)
                .into(imageView);

    }
}
