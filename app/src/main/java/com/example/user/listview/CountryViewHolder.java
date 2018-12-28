package com.example.user.listview;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CountryViewHolder extends RecyclerView.ViewHolder {

    TextView Title;

    public CountryViewHolder(View itemView) {
        super(itemView);
        Title = itemView.findViewById(R.id.textview_section_header);
    }

}
