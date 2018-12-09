package com.example.geo.museumguide.connection.user;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.MainActivity;
import com.example.geo.museumguide.HomeActivity;
import com.example.geo.museumguide.bean.LoginBean;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.model.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Geo on 1/7/2017.
 */

public class LoginInRequestTask extends AsyncTask<Void, Void, User> {

    private LoginBean bean;
    private Activity source;

    public LoginInRequestTask(LoginBean bean, Activity source) {
        this.bean = bean;
        this.source = source;
    }

    @Override
    protected User doInBackground(Void... params) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            User result = restTemplate.postForObject(RESTConst.USER_LOGIN_REST_PATH, bean, User.class);
            return result;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(User user) {
        if(user!=null) {
            Toast.makeText(source, "It seems to work" + user, Toast.LENGTH_LONG).show();
            LogInService.logIn(user);
            Intent intent = new Intent(source.getApplicationContext(), HomeActivity.class);
            source.startActivityForResult(intent, MainActivity.REQUEST_SIGNUP);

        }else{
            Toast.makeText(source, "Neh", Toast.LENGTH_LONG).show();
        }
    }

}
