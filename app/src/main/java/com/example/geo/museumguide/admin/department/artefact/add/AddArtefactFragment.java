package com.example.geo.museumguide.admin.department.artefact.add;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.connection.artefact.CreateArtefactTask;
import com.example.geo.museumguide.model.Artefact;

/**
 * Created by Geo on 1/12/2017.
 */

public class AddArtefactFragment extends Activity {

    private EditText titleText;
    private EditText authorText;
    private EditText yearText;
    private EditText departmentIdTextArtefact;
    private EditText descriptionText;
    private FloatingActionButton addBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_artefact_fr);


        titleText = (EditText) findViewById(R.id.titleText);
        authorText = (EditText) findViewById(R.id.authorText);
        yearText = (EditText) findViewById(R.id.yearText);
        descriptionText = (EditText) findViewById(R.id.descriptionText);
        departmentIdTextArtefact = (EditText) findViewById(R.id.departmentIdTextArtefact);

        addBtn = (FloatingActionButton) findViewById(R.id.addFloatingActionButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleText.getText().toString();
                String author = authorText.getText().toString();
                int year = Integer.parseInt(yearText.getText().toString());
                String description = descriptionText.getText().toString();
                int dep_id = Integer.parseInt(departmentIdTextArtefact.getText().toString());

                Artefact artefact = new Artefact(title, author, year, description,dep_id);

                new CreateArtefactTask(artefact, AddArtefactFragment.this).execute();
            }
        });

    }
}
