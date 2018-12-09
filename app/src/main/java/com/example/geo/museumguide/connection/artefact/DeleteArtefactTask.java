package com.example.geo.museumguide.connection.artefact;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.model.Artefact;
import com.example.geo.museumguide.model.User;
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
 * Created by Geo on 2/3/2017.
 */

public class DeleteArtefactTask extends AsyncTask<Object, Void, ArtefactBean> {

    private Activity source;

    public DeleteArtefactTask(Activity source) {
        this.source = source;
    }
    public DeleteArtefactTask(){
        
    }


    @Override
    protected ArtefactBean doInBackground(Object... params) {
        Integer id = (Integer) params[0];
        try {
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<Artefact> entity = new HttpEntity<>(headers);

            String uri = RESTConst.getByIdPath(RESTConst.ARTEFACT_REST_PATH, id);

            ResponseEntity<ArtefactBean> result = restTemplate.exchange(uri, HttpMethod.DELETE, entity, ArtefactBean.class);

            return result.getBody();
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArtefactBean artefact) {
        if (artefact == null) {
            Toast.makeText(source, "Artefact was deleted!", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(source, "Artifact not deleted!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(source, NFCTourActivity.class);
        intent.putExtra("artefact", artefact);
        source.startActivity(intent);

    }
}