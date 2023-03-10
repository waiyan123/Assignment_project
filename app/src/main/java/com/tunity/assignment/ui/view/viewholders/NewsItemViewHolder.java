package com.tunity.assignment.ui.view.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tunity.assignment.R;

public class NewsItemViewHolder extends RecyclerView.ViewHolder {
    public ImageView imgArticleBanner;
    public TextView tvAuthor;
    public TextView tvTitle;
    public NewsItemViewHolder(View itemView) {
        super(itemView);
        imgArticleBanner = itemView.findViewById(R.id.img_list_item_banner);
        tvAuthor = itemView.findViewById(R.id.tv_author_item);
        tvTitle = itemView.findViewById(R.id.tv_title_item);
    }
}
