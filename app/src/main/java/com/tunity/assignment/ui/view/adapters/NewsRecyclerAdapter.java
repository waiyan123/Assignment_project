package com.tunity.assignment.ui.view.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.tunity.assignment.R;
import com.tunity.assignment.data.database.room.entity.ArticleEntity;
import com.tunity.assignment.ui.view.listeners.AdapterPositionListener;
import com.tunity.assignment.ui.view.listeners.ListItemOnClickListener;
import com.tunity.assignment.ui.view.viewholders.NewsItemViewHolder;
import java.util.List;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsItemViewHolder> {

    private List<ArticleEntity> newsList;
    private final ListItemOnClickListener itemOnClickListener;
    private final AdapterPositionListener positionListener;

    public NewsRecyclerAdapter(ListItemOnClickListener itemOnClickListener, AdapterPositionListener positionListener) {
        this.itemOnClickListener = itemOnClickListener;
        this.positionListener = positionListener;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setNewData(List<ArticleEntity>list) {
        newsList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_news,parent,false);
        return new NewsItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsItemViewHolder holder, int position) {
        if(!newsList.isEmpty()) {
            if(newsList.get(position).title!=null) holder.tvTitle.setText(newsList.get(position).title);
            if(newsList.get(position).author!=null) holder.tvAuthor.setText(newsList.get(position).author);
            if(newsList.get(position).urlToImage!=null) {
                Glide.with(holder.itemView)
                        .load(newsList.get(position).urlToImage)
                        .placeholder(R.drawable.img_placeholder)
                        .into(holder.imgArticleBanner);
            }
            holder.itemView.setOnClickListener(view ->
                    itemOnClickListener.onClickItem(newsList.get(position)));
            positionListener.onPosition(position);
        }
    }

    @Override
    public int getItemCount() {
        if(newsList!=null) {
            return newsList.size();
        }else return 0;
    }
}
