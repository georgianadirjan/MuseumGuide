package com.example.geo.museumguide.connection.favorite;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.geo.museumguide.connection.user.LogInService;
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
 * Created by Geo on 2/11/2017.
 */

public class RemoveEntryToFavourites extends AsyncTask<Object, Void, Object> {

    private String baseURI;
    private Context context;

    public RemoveEntryToFavourites(String baseURI, Context context) {
        this.baseURI = baseURI;
        this.context = context;
    }

    @Override
    protected Object doInBackground(Object... objects) {
        if(objects == null || objects.length!=1){
            Toast.makeText(context, "Please provide entry id to remove from favourites!", Toast.LENGTH_LONG).show();
            return null;
        }
        Long id = (Long) objects[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpHeaders headers = new HttpHeaders();
        headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
        HttpEntity<User> entity = new HttpEntity<User>(headers);

        String uri = RESTConst.getByIdPath(baseURI, id);

        ResponseEntity<Object> result = restTemplate.exchange(uri, HttpMethod.DELETE, entity, Object.class);
        return result.getBody();
    }

    @Override
    protected void onPostExecute(Object object) {
        Toast.makeText(context, "Entry removed from favourites!", Toast.LENGTH_LONG).show();

    }
}
