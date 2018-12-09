package com.example.geo.museumguide.admin.user.update;

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
import android.widget.TextView;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.connection.user.RegisterRequestTask;
import com.example.geo.museumguide.connection.user.UpdateLoggedUserTask;
import com.example.geo.museumguide.model.User;

/**
 * Created by Geo on 1/7/2017.
 */

public class UpdateLoggedUserActivity extends Activity {


    private TextView firstNameTxt;
    private EditText firstName;
    private TextView lastNameTxt;
    private EditText lastName;
    private TextView usernameTxt;
    private EditText username;
    private TextView passwordText;
    private EditText password;
    private Button updateButton;

    public UpdateLoggedUserActivity(){

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_layout);

        firstName = (EditText) findViewById
                (R.id.firstname_txt);
        lastName = (EditText)findViewById(R.id.lastname_txt);
        username = (EditText) findViewById(R.id.username_txt);
        password = (EditText) findViewById(R.id.password_text);

        firstNameTxt = (TextView) findViewById(R.id.firstname);
        lastNameTxt = (TextView) findViewById(R.id.lastname);
        usernameTxt = (TextView) findViewById(R.id.username);
        passwordText = (TextView) findViewById(R.id.password);

        updateButton = (Button) findViewById(R.id.upD);

        final User loggedUser = LogInService.getLoggedUser();

        firstName.setText(loggedUser.getFirstName());
        lastName.setText(loggedUser.getLastName());
        password.setText(loggedUser.getPassword());
        username.setText(loggedUser.getUserName());



        updateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                User user = new User();
                user.setId(LogInService.getLoggedUser().getId());
                user.setFirstName(firstName.getText().toString());
                user.setLastName(lastName.getText().toString());
                user.setUserName(username.getText().toString());
                user.setPassword(password.getText().toString());
                new UpdateLoggedUserTask(user, UpdateLoggedUserActivity.this).execute();
            }
        });
    }


}
