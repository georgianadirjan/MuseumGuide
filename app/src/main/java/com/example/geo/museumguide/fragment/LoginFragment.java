package com.example.geo.museumguide.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.bean.LoginBean;
import com.example.geo.museumguide.connection.user.LoginInRequestTask;

/**
 * Created by Geo on 1/6/2017.
 */

public class LoginFragment extends Fragment {

    EditText username;
    EditText password;
    Button loginButton;

        public LoginFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.login_fragment_layout,container,false);

        username = (EditText) view.findViewById(R.id.firstname_txt);
        password = (EditText) view.findViewById(R.id.lastname_txt);

        loginButton = (Button) view.findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // do something
               // Toast.makeText(getActivity(),"Your Message", Toast.LENGTH_LONG).show();

                String usernameTxt=username.getText().toString();
                String passwordTxt=password.getText().toString();
                LoginBean bean = new LoginBean(usernameTxt, passwordTxt);
                new LoginInRequestTask(bean, getActivity()).execute();


            }
        });



        return view;
    }
}
