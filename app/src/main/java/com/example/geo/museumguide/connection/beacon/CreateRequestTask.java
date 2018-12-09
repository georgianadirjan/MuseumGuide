package com.example.geo.museumguide.connection.beacon;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.Beacon;
import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.model.Artefact;
import com.example.geo.museumguide.model.User;

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

public class CreateRequestTask extends AsyncTask<Void, Void, Beacon> {

    private Beacon beacon;
    private Activity source;

    public CreateRequestTask(Beacon beacon, Activity source) {
        this.beacon = beacon;
        this.source = source;
    }
    public CreateRequestTask(User bean) {
        this.beacon = beacon;
    }

    @Override
    protected Beacon doInBackground(Void... params) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<Beacon> entity = new HttpEntity<>(beacon, headers);

            ResponseEntity<Beacon> result = restTemplate.exchange(RESTConst.BEACON_REST_PATH, HttpMethod.POST, entity, Beacon.class);
            return result.getBody();
        } catch (Exception e) {
            Log.e("AddBeaconActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Beacon beacon) {
        if(beacon!=null) {
            Toast.makeText(source, "beacon created!", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(source, "Neh", Toast.LENGTH_LONG).show();
        }
    }

}
