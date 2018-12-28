package com.example.user.listview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        DragHelper.ActionCompletionContract {
    private static final int CITY_TYPE = 1;
    private static final int COUNTRY_TYPE = 2;
    private List<Places> placesList;
    private ItemTouchHelper touchHelper;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case CITY_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_cities_item, parent, false);
                return new ViewHolder(view);
            case COUNTRY_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_country_header, parent, false);
                return new CountryViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_cities_item, parent, false);
                return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == CITY_TYPE) {
            ((ViewHolder) holder).username.setText(placesList.get(position).getName());
            ((ViewHolder) holder).reorderView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                        touchHelper.startDrag(holder);
                    }
                    return false;
                }
            });
        } else {
            CountryViewHolder headerViewHolder = (CountryViewHolder) holder;
            headerViewHolder.Title.setText(placesList.get(position).getType());
        }
    }

    @Override
    public int getItemCount() {

        return placesList == null ? 0 : placesList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(placesList.get(position).getName())) {
            return COUNTRY_TYPE;
        } else {
            return CITY_TYPE;
        }
    }

    public void setUserList(List<Places> placesList) {
        this.placesList = placesList;
        notifyDataSetChanged();
    }

    @Override
    public void onViewMoved(int oldPosition, int newPosition) {
        Places targetUser = placesList.get(oldPosition);
        Places user = new Places(targetUser);
        Places newPos=placesList.get(newPosition);
        if(user.countryId()==newPos.countryId()) {
            placesList.remove(oldPosition);

            placesList.add(newPosition, user);
            notifyItemMoved(oldPosition, newPosition);
        }
    }


    public void setTouchHelper(ItemTouchHelper touchHelper) {

        this.touchHelper = touchHelper;
    }
}
