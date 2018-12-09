package com.example.geo.museumguide.favorite.task;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.connection.photo_artefact.PhotoArtefact;
import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.gallery.GalleryActivity;

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
 * Created by Geo on 2/7/2017.
 */

public class GetFavoritePhotoArtefactTask extends AsyncTask<Object, Void, List<PhotoArtefact>> {

    private Activity source;
    private ArrayList<PhotoArtefact> artefacts;

    public GetFavoritePhotoArtefactTask(Activity source) {
        this.source = source;
        artefacts = new ArrayList<PhotoArtefact>();
    }

    public GetFavoritePhotoArtefactTask() {

    }

    public ArrayList<PhotoArtefact> getArtefacts() {
        return artefacts;
    }

    public void setArtefacts(ArrayList<PhotoArtefact> artefacts) {
        this.artefacts = artefacts;
    }

    @Override
    protected List<PhotoArtefact> doInBackground(Object... params) {
        Long id=null;
        if(params!=null &&params.length==1) {
            id = (Long) params[0];
        }
        try{
            String uri = RESTConst.FOTO_ARTEFACT_PATH;
            if(id!=null){
                uri =RESTConst.getByIdPath(RESTConst.FOTO_ARTEFACT_BY_ARTEFACT_PATH,id);
            }
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<PhotoArtefact> entity = new HttpEntity<>(headers);
            RestTemplate template = new RestTemplate(true);

            ResponseEntity<PhotoArtefact[]> responseEntity = template.exchange(uri, HttpMethod.GET, entity, PhotoArtefact[].class);

            return Arrays.asList(responseEntity.getBody());
        } catch (Exception e) {
            Log.e("PhotoArtefact", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<PhotoArtefact> artefactL) {
        if (artefactL == null) {
            Toast.makeText(source, "Artifacts data not found, please try again!", Toast.LENGTH_LONG).show();
            return;
        }
        List<PhotoArtefact> artefacts = new ArrayList<>();
        for(PhotoArtefact photoArtefact:artefactL){
            if(photoArtefact.isFavorite()){
                artefacts.add(photoArtefact);
            }
        }
        Intent intent=new Intent(source, GalleryActivity.class);
        intent.putExtra("artefactList",(Serializable) artefacts);
        source.startActivity(intent);
    }


}
