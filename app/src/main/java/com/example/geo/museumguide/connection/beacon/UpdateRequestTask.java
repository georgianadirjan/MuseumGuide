package com.example.geo.museumguide.connection.beacon;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.Beacon;
import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.model.Artefact;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by Geo on 1/12/2017.
 */

public class UpdateRequestTask extends AsyncTask<Object, Void, Beacon> {

    private Beacon beacon;
    private Activity source;

    public UpdateRequestTask(Beacon beacon, Activity source) {
        this.beacon = beacon;
        this.source = source;
    }

    @Override
    protected Beacon doInBackground(Object... params) {
        Integer id=(Integer)params[0];
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<Beacon> entity = new HttpEntity<>(beacon, headers);
            String uri = RESTConst.getByIdPath(RESTConst.BEACON_REST_PATH,id);

            ResponseEntity<Beacon> result = restTemplate.exchange(uri, HttpMethod.PUT, entity, Beacon.class);
            return result.getBody();
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Beacon beacon) {
        if (beacon != null) {
            Toast.makeText(source, "Modified beacon!", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(source, "Not modified", Toast.LENGTH_LONG).show();
        }
    }
}


