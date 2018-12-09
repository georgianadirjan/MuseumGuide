package com.example.geo.museumguide.admin.user.update;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.connection.user.UpdateLoggedUserTask;
import com.example.geo.museumguide.connection.user.UpdateUserTask;
import com.example.geo.museumguide.model.User;

/**
 * Created by Geo on 2/7/2017.
 */

public class UpdateUserFragment extends Activity {


    private EditText idEditText;
    private EditText firstName;
    private EditText lastName;
    private EditText username;
    private EditText password;
    private Button updateButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_unlogged);


        idEditText = (EditText) findViewById(R.id.id_textLoggedAdmin);
        firstName = (EditText) findViewById(R.id.firstname_txtLoggedAdmin);
        lastName = (EditText)findViewById(R.id.lastname_txtLoggedAdmin);
        username = (EditText) findViewById(R.id.username_txtLoggedAdmin);
        password = (EditText) findViewById(R.id.password_textLoggedAdmin);



        updateButton = (Button) findViewById(R.id.editUserUnlogged);


        updateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                User user = new User();
                Long id=Long.parseLong(idEditText.getText().toString());
                user.setId(id);
                Integer idIntegerV=Integer.parseInt(idEditText.getText().toString());
                user.setFirstName(firstName.getText().toString());
                user.setLastName(lastName.getText().toString());
                user.setUserName(username.getText().toString());
                user.setPassword(password.getText().toString());
                new UpdateUserTask(user, UpdateUserFragment.this).execute(idIntegerV);
            }
        });
    }
}
