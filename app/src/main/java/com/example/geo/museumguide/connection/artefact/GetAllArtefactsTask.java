package com.example.geo.museumguide.connection.artefact;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.admin.department.artefact.show.ArtefactCrudOperationsActivity;
import com.example.geo.museumguide.admin.department.artefact.show.ArtefactShowList;
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

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Geo on 2/3/2017.
 */

public class GetAllArtefactsTask extends AsyncTask<Object, Void, List<Artefact>> {

    private Activity source;
    private ArrayList<Artefact> artefacts;

    public GetAllArtefactsTask(Activity source) {
        this.source = source;
        artefacts=new ArrayList<Artefact>();
    }

    public GetAllArtefactsTask() {

    }

    public ArrayList<Artefact> getArtefacts() {
        return artefacts;
    }

    public void setArtefacts(ArrayList<Artefact> artefacts) {
        this.artefacts = artefacts;
    }

    @Override
    protected List<Artefact> doInBackground(Object... params) {
        try {
           /*
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<User> entity = new HttpEntity<User>(headers);
*/
            String uri = RESTConst.ARTEFACT_REST_PATH;
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<Artefact> entity = new HttpEntity<>(headers);

            // ResponseEntity<List<Artefact>> res = restTemplate.postForEntity(uri, entity, new ParameterizedTypeReference<List<Artefact>>() {});

          //  ResponseEntity<? extends ArrayList<Artefact>> responseEntity = restTemplate.getForEntity(uri, (Class<? extends ArrayList<Artefact>>)ArrayList.class, id);
            RestTemplate template = new RestTemplate(true);

            ResponseEntity<Artefact[]> responseEntity = template.exchange(uri,HttpMethod.GET,entity, Artefact[].class);
            return new ArrayList<Artefact>(Arrays.asList(responseEntity.getBody()));
            // return  restTemplate.postForObject(uri,  HttpMethod.POST,null, new  FakeParameterizedTypeReference<ResponseWrapper<Artefact>>());
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Artefact> artefact) {
        if (artefact == null) {
            Toast.makeText(source, "Artifact not found, please try again!", Toast.LENGTH_LONG).show();
            return;
        }
        Intent i4 = new Intent(source, ArtefactShowList.class);
        i4.putExtra("artefactList", (Serializable) artefact);
        source.startActivity(i4);

    }


}
