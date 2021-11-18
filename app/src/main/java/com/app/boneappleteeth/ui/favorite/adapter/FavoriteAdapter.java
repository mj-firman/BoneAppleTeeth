package com.app.boneappleteeth.ui.favorite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.boneappleteeth.databinding.ItemResepBinding;
import com.app.boneappleteeth.ui.favorite.model.Favorite;

import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {
    private List<Favorite> searchList = new ArrayList<>();
    private Context context;

    public FavoriteAdapter(Context context, List<Favorite> newsList) {
        this.context = context;
        this.searchList = newsList;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemResepBinding binding = ItemResepBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FavoriteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        Favorite search = searchList.get(position);

        holder.binding.ivResep.setImageResource(search.getImagePath());

        if((position+1) % 2 != 0) {
            holder.binding.clLikeLeft.setVisibility(View.VISIBLE);
            holder.binding.clLikeRight.setVisibility(View.GONE);
            holder.binding.tvTitleLeft.setText(search.getTitle());
            holder.binding.tvTitleLeft.setText(search.getMenit());
        } else {
            holder.binding.clLikeRight.setVisibility(View.VISIBLE);
            holder.binding.clLikeLeft.setVisibility(View.GONE);
            holder.binding.tvTitle.setText(search.getTitle());
            holder.binding.tvMenit.setText(search.getMenit());
        }

        holder.binding.tvTitle.setText(search.getTitle());
        holder.binding.tvMenit.setText(search.getMenit());
        holder.binding.ivResep.setImageResource(search.getImagePath());
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

    static  class FavoriteViewHolder extends RecyclerView.ViewHolder {
        ItemResepBinding binding;

        FavoriteViewHolder(ItemResepBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}