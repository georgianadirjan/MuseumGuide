package com.example.geo.museumguide.department.task;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.connection.photo_artefact.PhotoArtefact;
import com.example.geo.museumguide.department.DepartmentInfo;

import java.util.List;

/**
 * Created by Geo on 2/11/2017.
 */

public class DepartmentDialog  extends Activity{

    ImageButton buttonDep;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department_layout_info);
         buttonDep = (ImageButton) findViewById(R.id.imagedep);
        TextView nameDepText = (TextView) findViewById(R.id.nameDepText);
        TextView beaconIDText = (TextView) findViewById(R.id.beaconIDtxt);
        TextView descriptionText = (TextView) findViewById(R.id.detailsDep1Text);
        DepartmentInfo dbean = (DepartmentInfo) getIntent().getSerializableExtra("depDialog");

        nameDepText.setText(dbean.getName());
        beaconIDText.setText(String.valueOf(dbean.getBeaconId()));
        descriptionText.setText(dbean.getDetails());

        buttonDep.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new GetAllDepartmentsTask(DepartmentDialog.this).execute();
            }
        });
    }
}
