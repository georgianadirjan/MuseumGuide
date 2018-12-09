package com.example.geo.museumguide.connection.user;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.bean.LoginBean;
import com.example.geo.museumguide.bean.RegisterBean;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.model.Artefact;
import com.example.geo.museumguide.model.User;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by Geo on 1/7/2017.
 */

public class RegisterRequestTask extends AsyncTask<Void, Void, User> {

    private User bean;
    private Activity source;

    public RegisterRequestTask(User bean, Activity source) {
        this.bean = bean;
        this.source = source;
    }
    public RegisterRequestTask(User bean) {
        this.bean = bean;
    }

    @Override
    protected User doInBackground(Void... params) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
     //       HttpHeaders headers = new HttpHeaders();
//            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<User> entity = new HttpEntity<>(bean);

            ResponseEntity<User> result = restTemplate.exchange(RESTConst.USER_REST_PATH, HttpMethod.POST, entity, User.class);
            return result.getBody();
        } catch (Exception e) {
            Log.e("CreateUserFragment", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(User user) {
        if(user!=null) {
            Toast.makeText(source, "User created!", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(source, "Neh", Toast.LENGTH_LONG).show();
        }
    }

}
