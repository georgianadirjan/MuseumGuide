package com.example.geo.museumguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.geo.museumguide.connection.user.RegisterRequestTask;
import com.example.geo.museumguide.model.User;

/**
 * Created by Geo on 1/9/2017.
 */

public class RegisterActivity extends Activity {


    private EditText firstName;
    private EditText lastName;
    private EditText username;
    private EditText password;
    private Button registerButton;
    private EditText email;
    TextView signInLink;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        firstName=(EditText)findViewById(R.id.firstname1);
        lastName=(EditText)findViewById(R.id.lastname1);
        username=(EditText)findViewById(R.id.etUserName);
        password=(EditText)findViewById(R.id.etUserName);
        email=(EditText)findViewById(R.id.etEmail);

        signInLink=(TextView)findViewById(R.id.signInBtn) ;

        registerButton=(Button)findViewById(R.id.btnSingIn);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setFirstName(firstName.getText().toString());
                user.setLastName(lastName.getText().toString());
                user.setUserName(username.getText().toString());
                user.setPassword(password.getText().toString());
               // user.setEmail(email.getText().toString());
               // user.setToken(user.getFirstName());
                new RegisterRequestTask(user,RegisterActivity.this).execute();
            }
        });

        signInLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(i);
            }
        });



    }
}
