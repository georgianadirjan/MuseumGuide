package com.example.geo.museumguide.department;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.connection.photo_artefact.PhotoArtefact;
import com.example.geo.museumguide.connection.photo_department.PhotoDepartment;
import com.example.geo.museumguide.events.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geo on 2/11/2017.
 */

public class DepartmentActivity extends Activity{


    private List<DepartmentInfo> departmentInfos;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_department);

        rv=(RecyclerView)findViewById(R.id.rvDepartment);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);


        departmentInfos = (List<DepartmentInfo>) getIntent().getSerializableExtra("departmentList");
        initializeAdapter();
    }



    private void initializeAdapter(){
   RVAdapter adapter = new RVAdapter(departmentInfos);
        rv.setAdapter(adapter);
    }

}
