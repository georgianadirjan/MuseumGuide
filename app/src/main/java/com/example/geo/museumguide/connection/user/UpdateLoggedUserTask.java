package com.example.geo.museumguide.connection.user;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.model.User;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by Geo on 1/7/2017.
 */

public class UpdateLoggedUserTask extends AsyncTask<Void, Void, User> {

    private User bean;
    private Activity source;

    public UpdateLoggedUserTask(User bean, Activity source) {
        this.bean = bean;
        this.source = source;
    }

    @Override
    protected User doInBackground(Void... params) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<User> entity = new HttpEntity<User>(bean, headers);
            String uri = RESTConst.getByIdPath(RESTConst.USER_REST_PATH, bean.getId());

            ResponseEntity<User> result = restTemplate.exchange(uri, HttpMethod.PUT, entity, User.class);
            return result.getBody();
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(User user) {
        if (user != null) {
            Toast.makeText(source, "User modified!", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(source, "Neh", Toast.LENGTH_LONG).show();
        }
    }


}
