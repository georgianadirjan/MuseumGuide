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

public class UpdateLoggedUserFragment extends Activity {


    EditText firstName;
    EditText lastName;
    EditText username;
    EditText password;
    EditText email;
    Button updateButton;

    public UpdateLoggedUserFragment() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_logged);

        firstName = (EditText) findViewById
                (R.id.firstname_txtLogged);
        lastName = (EditText) findViewById(R.id.lastname_txtLogged);
        username = (EditText) findViewById(R.id.username_txtLogged);
        password = (EditText) findViewById(R.id.password_textLogged);
        email = (EditText) findViewById(R.id.email_textLogged);

        updateButton = (Button) findViewById(R.id.btnLogged);

        final User loggedUser = LogInService.getLoggedUser();

       /* firstName.setText(loggedUser.getFirstName());
        lastName.setText(loggedUser.getLastName());
        password.setText(loggedUser.getPassword());
        username.setText(loggedUser.getUserName());
*/


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setId(LogInService.getLoggedUser().getId());
                user.setFirstName(firstName.getText().toString());
                user.setLastName(lastName.getText().toString());
                user.setUserName(username.getText().toString());
                user.setPassword(password.getText().toString());
                new UpdateLoggedUserTask(user, UpdateLoggedUserFragment.this).execute();

            }
        });

    }
}