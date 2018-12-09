package com.example.geo.museumguide.favorite.task;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.admin.department.artefact.show.ArtefactShowList;
import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.model.Artefact;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Geo on 2/3/2017.
 */

public class GetAllFavoritesArtefactsTask extends AsyncTask<Object, Void, List<Artefact>> {

    private Activity source;
    private ArrayList<Artefact> artefacts;

    public GetAllFavoritesArtefactsTask(Activity source) {
        this.source = source;
        artefacts=new ArrayList<Artefact>();
    }

    public GetAllFavoritesArtefactsTask() {

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
            String uri = RESTConst.ARTEFACT_REST_PATH;
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<Artefact> entity = new HttpEntity<>(headers);
            RestTemplate template = new RestTemplate(true);

            ResponseEntity<Artefact[]> responseEntity = template.exchange(uri,HttpMethod.GET,entity, Artefact[].class);
            return new ArrayList<Artefact>(Arrays.asList(responseEntity.getBody()));
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
        List<Artefact> favouriteArtefacts = new ArrayList<>();
        for(Artefact artef:artefact){
            if(artef.isFavorite()){
                favouriteArtefacts.add(artef);
            }
        }
        Intent i4 = new Intent(source, ArtefactShowList.class);
        i4.putExtra("artefactList", (Serializable) favouriteArtefacts);
        source.startActivity(i4);

    }


}
