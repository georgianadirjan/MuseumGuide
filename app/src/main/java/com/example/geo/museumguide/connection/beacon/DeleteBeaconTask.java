package com.example.geo.museumguide.connection.beacon;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.Beacon;
import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.model.Artefact;
import com.example.geo.museumguide.tour.ArtefactBean;
import com.example.geo.museumguide.tour.NFCTourActivity;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by Geo on 2/7/2017.
 */

public class DeleteBeaconTask extends AsyncTask<Object, Void, Beacon> {

    private Activity source;

    public DeleteBeaconTask(Activity source) {
        this.source = source;
    }
    public DeleteBeaconTask(){

    }


    @Override
    protected Beacon doInBackground(Object... params) {
        Integer id = (Integer) params[0];
        try {
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<Beacon> entity = new HttpEntity<>(headers);

            String uri = RESTConst.getByIdPath(RESTConst.BEACON_REST_PATH, id);

            ResponseEntity<Beacon> result = restTemplate.exchange(uri, HttpMethod.DELETE, entity, Beacon.class);

            return result.getBody();
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Beacon beacon) {
        if (beacon == null) {
            Toast.makeText(source, "Beacon was deleted!", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(source, "Beacon not deleted!", Toast.LENGTH_LONG).show();

    }
}
