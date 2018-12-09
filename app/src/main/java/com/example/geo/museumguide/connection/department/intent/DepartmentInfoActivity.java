package com.example.geo.museumguide.connection.department.intent;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.department.DepartmentInfo;


/**
 * Created by Geo on 1/29/2017.
 */

public class DepartmentInfoActivity extends Activity {


    private TextView nameText;
    private TextView beaconIDText;
    private TextView descriptionText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department_layout_info);
        final DepartmentInfo departmentBean= (DepartmentInfo) getIntent().getExtras().get("department");

        nameText=(TextView) findViewById(R.id.nameDepText);
        beaconIDText=(TextView) findViewById(R.id.beaconIDtxt);
        descriptionText=(TextView) findViewById(R.id.detailsDep1Text);


        nameText.setText(departmentBean.getName());
        beaconIDText.setText(String.valueOf(departmentBean.getBeaconId()));
        descriptionText.setText(departmentBean.getDetails());
    }
}
