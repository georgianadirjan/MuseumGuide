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
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by Geo on 1/10/2017.
 */

public class UpdateArtefactTask extends AsyncTask<Object, Void, Artefact> {
    private Artefact bean;
    private Activity source;

    public UpdateArtefactTask(Artefact bean,Activity source) {
        this.bean = bean;
        this.source = source;
    }

    @Override
    protected Artefact doInBackground(Object... params) {
        Integer id=(Integer)params[0];
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<Artefact> entity = new HttpEntity<>(bean, headers);
            String uri = RESTConst.getByIdPath(RESTConst.ARTEFACT_REST_PATH,id);

            ResponseEntity<Artefact> result = restTemplate.exchange(uri, HttpMethod.PUT, entity, Artefact.class);
            return result.getBody();
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Artefact artefact) {
        if (artefact != null) {
            Toast.makeText(source, "artefact modified!", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(source, "Neh", Toast.LENGTH_LONG).show();
        }
    }
}

