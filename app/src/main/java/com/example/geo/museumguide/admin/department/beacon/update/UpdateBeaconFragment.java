package com.example.geo.museumguide.admin.department.beacon.update;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.geo.museumguide.Beacon;
import com.example.geo.museumguide.R;
import com.example.geo.museumguide.connection.beacon.CreateRequestTask;
import com.example.geo.museumguide.connection.beacon.UpdateRequestTask;

/**
 * Created by Geo on 1/12/2017.
 */

public class UpdateBeaconFragment extends Activity {

    private EditText idText;
    private EditText uuidText;
    private EditText majorText;
    private EditText minorText;
    private EditText textT;
    private FloatingActionButton floatingActionButtonadd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_beacon_fr);

        idText = (EditText) findViewById(R.id.idBeacon);
        uuidText = (EditText) findViewById(R.id.uuidText1);
        majorText = (EditText) findViewById(R.id.majorText1);
        minorText = (EditText) findViewById(R.id.minorText1);
       // textT = (EditText) findViewById(R.id.textT1);

        floatingActionButtonadd = (FloatingActionButton) findViewById(R.id.updateBeaconBtn);
        floatingActionButtonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(idText.getText().toString());
                String uuid = uuidText.getText().toString();
                int major = Integer.parseInt(majorText.getText().toString());
                int minor = Integer.parseInt(minorText.getText().toString());
               // String text = textT.getText().toString();

                Beacon beacon = new Beacon(uuid, major, minor);

                new UpdateRequestTask(beacon, UpdateBeaconFragment.this).execute(id);
            }
        });

    }

}
