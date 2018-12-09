package com.example.geo.museumguide.admin.department.beacon.delete;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.admin.department.artefact.delete.DeleteArtefactFragment;
import com.example.geo.museumguide.connection.artefact.DeleteArtefactTask;
import com.example.geo.museumguide.connection.beacon.DeleteBeaconTask;

/**
 * Created by Geo on 1/13/2017.
 */

public class DeleteBeaconFragment extends Activity {

    private EditText beaconIdText;
    private FloatingActionButton deleteBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.delete_beacon_fr);

        beaconIdText = (EditText) findViewById(R.id.beaconIdText);

        deleteBtn = (FloatingActionButton) findViewById(R.id.deleteBeaconBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id=beaconIdText.getText().toString();
                new DeleteBeaconTask(DeleteBeaconFragment.this).execute(Integer.valueOf(id));

            }
        });

    }
}