package com.example.geo.museumguide.admin.user.delete;

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
import com.example.geo.museumguide.connection.user.DeleteUserTask;

/**
 * Created by Geo on 1/13/2017.
 */

public class DeleteUserFragment extends Activity {


    private EditText userIdText;
    private FloatingActionButton deleteBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_user_fr);
        userIdText = (EditText) findViewById(R.id.userIdText);

        deleteBtn = (FloatingActionButton) findViewById(R.id.deleteUserBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             String id=userIdText.getText().toString();
                                             new DeleteUserTask(DeleteUserFragment.this).execute(Integer.valueOf(id));
                                         }
                                     }
        );

    }

}
