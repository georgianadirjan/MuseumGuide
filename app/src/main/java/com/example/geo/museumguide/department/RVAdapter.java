package com.example.geo.museumguide.department;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.connection.photo_department.PhotoDepartment;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.department.task.GetAllDepartmentsTask;
import com.example.geo.museumguide.gallery.DownloadImageTask;

import java.util.List;

/**
 * Created by Geo on 2/11/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.EventViewHolder> {


    public static class EventViewHolder extends RecyclerView.ViewHolder {

        CardView depCard;
        TextView nameDep;
        TextView descriptionExpo;
        ImageButton depPhoto;

        EventViewHolder(View itemView) {
            super(itemView);
            depCard = (CardView)itemView.findViewById(R.id.expoDepartment);
            nameDep = (TextView)itemView.findViewById(R.id.event_name);
            descriptionExpo = (TextView)itemView.findViewById(R.id.event_description);
            depPhoto = (ImageButton) itemView.findViewById(R.id.event_photoDepartment);
        }
    }

    List<DepartmentInfo> departmentInforList;

    RVAdapter(List<DepartmentInfo> departmentInforList){
        super();
        this.departmentInforList = departmentInforList;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_department, viewGroup, false);
        EventViewHolder pvh = new RVAdapter.EventViewHolder(v);


        return pvh;
    }



    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {

        holder.nameDep.setText(departmentInforList.get(position).getName());
        holder.descriptionExpo.setText(departmentInforList.get(position).getDetails());
        //new DownloadImageTask(holder.depPhoto).execute(RESTConst.getImagePath(departmentInforList.get(position).getPath()));

        holder.depPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    @Override
    public int getItemCount() {
        return departmentInforList.size();
    }


}

