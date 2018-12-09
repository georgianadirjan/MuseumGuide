package com.example.geo.museumguide.department;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.events.ExpoCardViewActivity;

/**
 * Created by Geo on 2/11/2017.
 */

public class DepartmentCard extends Activity {

    TextView eventName;
    TextView eventDescription;
    ImageButton eventPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.event_department);
        eventName = (TextView) findViewById(R.id.event_nameDepartment);
        eventDescription = (TextView) findViewById(R.id.event_descriptionDepartment);

        eventPhoto = (ImageButton) findViewById(R.id.event_photoDepartment);


        eventName.setText("Emma Wilson");
        eventDescription.setText("23 years old");
        eventPhoto.setImageResource(R.drawable.art1);
    }
}
