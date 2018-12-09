package com.example.geo.museumguide.admin.user.add;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.bean.LoginBean;
import com.example.geo.museumguide.bean.RegisterBean;
import com.example.geo.museumguide.connection.user.LoginInRequestTask;
import com.example.geo.museumguide.connection.user.RegisterRequestTask;
import com.example.geo.museumguide.model.User;

/**
 * Created by Geo on 1/6/2017.
 */

public class CreateUserFragment extends Activity {

    private TextView firstNameTxt;
    private EditText firstName;
    private TextView lastNameTxt;
    private EditText lastName;
    private TextView usernameTxt;
    private EditText username;
    private TextView passwordText;
    private EditText password;
    private FloatingActionButton addBtn;


    public CreateUserFragment() {
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_fragment_layout);

        firstName = (EditText) findViewById(R.id.firstname_txt);
        lastName = (EditText) findViewById(R.id.lastname_txt);
        username = (EditText) findViewById(R.id.username_txt);
        password = (EditText) findViewById(R.id.password_text);

        firstNameTxt = (TextView) findViewById(R.id.firstname);
        lastNameTxt = (TextView) findViewById(R.id.lastname);
        usernameTxt = (TextView) findViewById(R.id.username);
        passwordText = (TextView) findViewById(R.id.password);

        addBtn = (FloatingActionButton) findViewById(R.id.adduserFloatingBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something
                // Toast.makeText(getActivity(),"Your Message", Toast.LENGTH_LONG).show();
                User user = new User();
                user.setFirstName(firstName.getText().toString());
                user.setLastName(lastName.getText().toString());
                user.setUserName(username.getText().toString());
                user.setPassword(password.getText().toString());
                user.setEmail(null);
                new RegisterRequestTask(user, CreateUserFragment.this).execute();


            }
        });

    }

}
