package com.example.geo.museumguide.connection.artefact;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

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
 * Created by Geo on 1/10/2017.
 */

public class CreateArtefactTask extends AsyncTask<Void, Void, Artefact> {

    private Artefact bean;
    private Activity source;

    public CreateArtefactTask(Artefact bean, Activity source) {
        this.bean = bean;
        this.source = source;
    }
    public CreateArtefactTask(Artefact bean) {
        this.bean = bean;
    }

    @Override
    protected Artefact doInBackground(Void... params) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<Artefact> entity = new HttpEntity<>(bean, headers);

            ResponseEntity<Artefact> result = restTemplate.exchange(RESTConst.ARTEFACT_REST_PATH, HttpMethod.POST, entity, Artefact.class);
            return result.getBody();
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Artefact artefact) {
        if(artefact!=null) {
            Toast.makeText(source, "Artefact created!", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(source, "Artefact can not be created!", Toast.LENGTH_LONG).show();
        }
    }
}
