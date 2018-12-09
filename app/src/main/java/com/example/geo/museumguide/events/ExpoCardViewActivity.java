package com.example.geo.museumguide.events;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geo.museumguide.R;

/**
 * Created by Geo on 2/1/2017.
 */

public class ExpoCardViewActivity extends Activity {

    TextView eventName;
    TextView eventDescription;
    TextView eventDate;
    TextView viewNumber;
    ImageView eventPhoto;
    // ImageButton imageBtnRmnder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.event_item);
        eventName = (TextView) findViewById(R.id.event_name);
        eventDescription = (TextView) findViewById(R.id.event_description);
        eventDate = (TextView) findViewById(R.id.event_date);
        viewNumber = (TextView) findViewById(R.id.event_viewsNb);
        eventPhoto = (ImageView) findViewById(R.id.event_photo);
        //  imageBtnRmnder=(ImageButton)findViewById(R.id.event_notifyBtn) ;

        eventName.setText("Emma Wilson");
        eventDescription.setText("23 years old");
        eventDate.setText("12 Ianuarie 2017");
        viewNumber.setText("0");
        eventPhoto.setImageResource(R.drawable.art1);
      /*  imageBtnRmnder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ExpoCardViewActivity.this,"Notify Me",Toast.LENGTH_LONG).show();
            }
        });
    }
    */
    }
}