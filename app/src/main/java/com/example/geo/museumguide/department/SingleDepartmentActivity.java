package com.example.geo.museumguide.department;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.connection.artefact.GetAllArtefactsByDepartmentTask;
import com.example.geo.museumguide.connection.photo_department.GetPhotoDepartmentTask;
import com.example.geo.museumguide.gallery.GalleryActivity;

import java.util.List;

/**
 * Created by Geo on 2/11/2017.
 */

public class SingleDepartmentActivity extends Activity{


    private DepartmentInfo departmentInfos;

    private ImageButton galleryButton;
    private ImageButton listArtefactsButton;
    private TextView name;
    private TextView details;



    //private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dep_act);

        name=(TextView)findViewById(R.id.nameDep);
        details=(TextView)findViewById(R.id.detailsDep);
        galleryButton=(ImageButton)findViewById(R.id.imageButtongalleryBtn);
        listArtefactsButton=(ImageButton)findViewById(R.id.imageButtonListArtefact);


       /* rv=(RecyclerView)findViewById(R.id.rvDepartment);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
*/

        departmentInfos = (DepartmentInfo) getIntent().getSerializableExtra("department");
        name.setText(departmentInfos.getName());
        details.setText(departmentInfos.getDetails());
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetPhotoDepartmentTask(SingleDepartmentActivity.this).execute(departmentInfos.getId());
            }
        });

        listArtefactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              new GetAllArtefactsByDepartmentTask(SingleDepartmentActivity.this).execute(departmentInfos.getId());
            }
        });
        //initializeAdapter();
    }



    private void initializeAdapter(){
    }

}
