package com.example.geo.museumguide.gallery;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.geo.museumguide.R;
import com.example.geo.museumguide.connection.favorite.AddEntryToFavourites;
import com.example.geo.museumguide.connection.favorite.RemoveEntryToFavourites;
import com.example.geo.museumguide.connection.photo_artefact.PhotoArtefact;
import com.example.geo.museumguide.constante.RESTConst;

import java.util.List;

/**
 * Created by Geo on 2/1/2017.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {

    private Context mContext;
    private List<PhotoArtefact> expoList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count,views;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            views = (TextView) view.findViewById(R.id.viewsGallery);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public GalleryAdapter(Context mContext, List<PhotoArtefact> expoList) {
        this.mContext = mContext;
        this.expoList = expoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,final int position) {
        PhotoArtefact expo = expoList.get(position);
        holder.title.setText(expo.getName());
        holder.count.setText("("+ expo.getAuthor()+ ": "+expo.getYear()+ " )");
        holder.views.setText(String.valueOf(expo.getViews()));

        // loading album cover using Glide library
        Glide.with(mContext).load(RESTConst.getImagePath(expo.getPath())).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow, position);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view, int position) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_exhibition_piece, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(position));
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
    private int position;
        public MyMenuItemClickListener(int position) {
            this.position = position;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                   // Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    new AddEntryToFavourites(RESTConst.FAVORITE_FOTO_ARTEFACT_REST_PATH, mContext).execute(expoList.get(position).getId());
                    return true;
                case R.id.action_remove_favourite:
                    // Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    new RemoveEntryToFavourites(RESTConst.FAVORITE_FOTO_ARTEFACT_REST_PATH, mContext).execute(expoList.get(position).getId());
                    return true;
                /*
                case R.id.action_share:
                    Toast.makeText(mContext, "Share", Toast.LENGTH_SHORT).show();
                    return true;
                    */
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return expoList.size();
    }
}
