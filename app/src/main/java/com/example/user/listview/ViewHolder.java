package com.example.user.listview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView userAvatar;
    TextView username;
    ImageView reorderView;

    public ViewHolder(View itemView) {
        super(itemView);

      //  userAvatar = itemView.findViewById(R.id.imageview_profile);
        username = itemView.findViewById(R.id.textview_name);
        reorderView = itemView.findViewById(R.id.imageview_reorder);
    }
}
