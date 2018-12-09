package com.example.geo.museumguide.admin.department.artefact.delete;

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
import com.example.geo.museumguide.admin.department.artefact.show.ArtefactCrudOperationsActivity;
import com.example.geo.museumguide.connection.artefact.DeleteArtefactTask;

/**
 * Created by Geo on 1/12/2017.
 */

public class DeleteArtefactFragment extends Activity {

    private EditText artefactIdText;
    private FloatingActionButton deleteBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_artefact_fragment);

        artefactIdText = (EditText)findViewById(R.id.artefactIdText);

        deleteBtn = (FloatingActionButton) findViewById(R.id.afb);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             String id=artefactIdText.getText().toString();
                                             new DeleteArtefactTask(DeleteArtefactFragment.this).execute(Integer.valueOf(id));
                                         }
                                     }
        );
    }


}
