package com.example.geo.museumguide.admin.department.beacon.add;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;

import com.example.geo.museumguide.Beacon;
import com.example.geo.museumguide.R;
import com.example.geo.museumguide.connection.beacon.CreateRequestTask;

/**
 * Created by Geo on 1/12/2017.
 */

public class AddBeaconFragment extends Activity {


    private EditText uuidText;
    private EditText majorText;
    private EditText minorText;
    private EditText textT;
    private FloatingActionButton floatingActionButtonadd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_beacon);

        uuidText = (EditText) findViewById(R.id.uuidText);
        majorText = (EditText) findViewById(R.id.majorText);
        minorText = (EditText) findViewById(R.id.minorText);
       // textT = (EditText) findViewById(R.id.textT);

        floatingActionButtonadd = (FloatingActionButton) findViewById(R.id.floatingActionButtonadd);
        floatingActionButtonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uuid = uuidText.getText().toString();
                int major = Integer.parseInt(majorText.getText().toString());
                int minor = Integer.parseInt(minorText.getText().toString());
              //  String text = textT.getText().toString();

                Beacon beacon = new Beacon(uuid, major, minor);

                new CreateRequestTask(beacon, AddBeaconFragment.this).execute();

            }
        });

    }
}