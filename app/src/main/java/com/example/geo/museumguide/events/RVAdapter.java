package com.example.geo.museumguide.events;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.connection.photo_department.PhotoDepartment;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.gallery.DownloadImageTask;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Geo on 2/1/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.EventViewHolder> {


    public static class EventViewHolder extends RecyclerView.ViewHolder {

        CardView eventExpo;
        TextView nameExpo;
        TextView descriptionExpo;
        TextView dateExpo;
        TextView viewNumber;
        ImageView eventPhoto;

        EventViewHolder(View itemView) {
            super(itemView);
            eventExpo = (CardView)itemView.findViewById(R.id.expoEvent);
            nameExpo = (TextView)itemView.findViewById(R.id.event_name);
            descriptionExpo = (TextView)itemView.findViewById(R.id.event_description);
            dateExpo = (TextView)itemView.findViewById(R.id.event_date);
            viewNumber = (TextView)itemView.findViewById(R.id.event_viewsNb);
            eventPhoto = (ImageView)itemView.findViewById(R.id.event_photo);
        }
    }

    List<PhotoDepartment> eventPiece;

    RVAdapter(List<PhotoDepartment> eventPiece){
        super();
        this.eventPiece = eventPiece;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_item, viewGroup, false);
        EventViewHolder pvh = new EventViewHolder(v);


        return pvh;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.nameExpo.setText(eventPiece.get(position).getName());
        holder.descriptionExpo.setText(eventPiece.get(position).getDescription());
        holder.dateExpo.setText(eventPiece.get(position).getDate());
        holder.viewNumber.setText(String.valueOf(eventPiece.get(position).getViews()));
        Log.d("PATHHH ",RESTConst.getImagePath(eventPiece.get(position).getPath()));
        new DownloadImageTask(holder.eventPhoto).execute(RESTConst.getImagePath(eventPiece.get(position).getPath()));
      /*  holder.dateExpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */
    }


    @Override
    public int getItemCount() {
        return eventPiece.size();
    }


}
