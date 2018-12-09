package com.example.geo.museumguide.events;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.connection.photo_artefact.GetPhotoArtefactTask;
import com.example.geo.museumguide.connection.photo_artefact.PhotoArtefact;
import com.example.geo.museumguide.connection.photo_department.GetPhotoDepartmentTask;
import com.example.geo.museumguide.connection.photo_department.PhotoDepartment;

import com.example.geo.museumguide.gallery.GalleryActivity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geo on 2/1/2017.
 */

public class ExpoRecyclerViewActivity extends Activity {

    private List<PhotoDepartment> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

       // initializeData();
        persons = (List<PhotoDepartment>) getIntent().getSerializableExtra("departmentList");
        Log.d("Shit",persons.toString());
        initializeAdapter();
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }


}
