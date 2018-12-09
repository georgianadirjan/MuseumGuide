package com.example.geo.museumguide.connection.favorite;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.model.Artefact;
import com.example.geo.museumguide.model.User;
import com.example.geo.museumguide.tour.ArtefactBean;

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

public class AddEntryToFavourites extends AsyncTask<Object, Void, Object> {


    private String baseURI;
    private Context context;

    public AddEntryToFavourites(String baseURI, Context context) {
        this.baseURI = baseURI;
        this.context = context;
    }

    @Override
    protected Object doInBackground(Object... objects) {
        if(objects == null || objects.length!=1){
            Toast.makeText(context, "Please provide entry id to add to favourites", Toast.LENGTH_LONG).show();
            return null;
        }
        Long id = (Long) objects[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpHeaders headers = new HttpHeaders();
        headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
        HttpEntity<User> entity = new HttpEntity<User>(headers);

        String uri = RESTConst.getByIdPath(baseURI, id);

        Log.d("PATH", uri);

        ResponseEntity<Object> result = restTemplate.exchange(uri, HttpMethod.GET, entity, Object.class);
        return result.getBody();
    }

    @Override
    protected void onPostExecute(Object object) {
        Toast.makeText(context, "Entry stored as favourite!", Toast.LENGTH_LONG).show();

    }
}
