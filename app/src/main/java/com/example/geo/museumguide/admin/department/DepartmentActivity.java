package com.example.geo.museumguide.admin.department;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.admin.department.artefact.show.ArtefactCrudOperationsActivity;
import com.example.geo.museumguide.admin.department.beacon.BeaconCRUDOperationsActivity;

/**
 * Created by Geo on 1/11/2017.
 */

public class DepartmentActivity extends Activity {

    private ImageButton beaconImgButton;
    private ImageButton artefactImgButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department_admin_layout);

        beaconImgButton=(ImageButton)findViewById(R.id.beaconImgButon);
        artefactImgButton=(ImageButton)findViewById(R.id.artefactImgButon);

        beaconImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b=new Intent(DepartmentActivity.this, BeaconCRUDOperationsActivity.class);
                startActivity(b);
            }
        });

        artefactImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DepartmentActivity.this, ArtefactCrudOperationsActivity.class);
                startActivity(i);
            }
        });

    }
}
