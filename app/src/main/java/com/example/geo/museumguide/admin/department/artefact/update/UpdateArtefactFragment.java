package com.example.geo.museumguide.admin.department.artefact.update;

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
import com.example.geo.museumguide.connection.artefact.CreateArtefactTask;
import com.example.geo.museumguide.connection.artefact.UpdateArtefactTask;
import com.example.geo.museumguide.model.Artefact;

/**
 * Created by Geo on 1/12/2017.
 */

public class UpdateArtefactFragment extends Activity {

    private EditText idText;
    private EditText titleText;
    private EditText authorText;
    private EditText yearText;
    private EditText descriptionText;
    private EditText departmentIdTextArtefact;
    private FloatingActionButton updateBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.update_artefact_fr);

        idText = (EditText) findViewById(R.id.idArtf);
        titleText = (EditText) findViewById(R.id.titleText1);
        authorText = (EditText) findViewById(R.id.authorText1);
        yearText = (EditText) findViewById(R.id.yearText1);
        descriptionText = (EditText) findViewById(R.id.descriptionText1);
        departmentIdTextArtefact = (EditText) findViewById(R.id.departmentIdTextArtefactUpdate);

        updateBtn = (FloatingActionButton) findViewById(R.id.updateFloatingActionButton);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(idText.getText().toString());
                String title = titleText.getText().toString();
                String author = authorText.getText().toString();
                int year = Integer.parseInt(yearText.getText().toString());
                String description = descriptionText.getText().toString();
                int dep_id = Integer.parseInt(departmentIdTextArtefact.getText().toString());

                Artefact artefact = new Artefact(title, author, year, description, dep_id);

                new UpdateArtefactTask(artefact, UpdateArtefactFragment.this).execute(id);
            }
        });
    }


}
