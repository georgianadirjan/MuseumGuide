package com.example.geo.museumguide.admin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.admin.department.DepartmentActivity;
import com.example.geo.museumguide.admin.user.UserActivity;

/**
 * Created by Geo on 1/7/2017.
 */

public class AdminActivity extends Activity {

    ImageButton departmentImg;
    ImageButton userImg;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_layout);

        departmentImg = (ImageButton) findViewById(R.id.departmentImgBtn);
        userImg = (ImageButton) findViewById(R.id.userImgBtb);

        //exhibitionImg = (ImageButton) findViewById(R.id.exhibitionImgBtn);

        departmentImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent depIntent = new Intent(AdminActivity.this, DepartmentActivity.class);
                startActivity(depIntent);
            }
        });

        userImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent depIntent = new Intent(AdminActivity.this, UserActivity.class);
                startActivity(depIntent);
            }
        });


    }
}
