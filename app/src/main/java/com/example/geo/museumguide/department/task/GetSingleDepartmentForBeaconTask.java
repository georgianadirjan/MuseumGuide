package com.example.geo.museumguide.department.task;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.connection.photo_artefact.PhotoArtefact;
import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.department.DepartmentActivity;
import com.example.geo.museumguide.department.DepartmentInfo;

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
 * Created by Geo on 2/11/2017.
 */

public class GetSingleDepartmentForBeaconTask extends AsyncTask<Object, Void, DepartmentInfo> {

    private Context source;

    public GetSingleDepartmentForBeaconTask(Context source) {
        this.source = source;
    }

    public GetSingleDepartmentForBeaconTask() {

    }
    @Override
    protected DepartmentInfo doInBackground(Object... params) {
        Long id = (Long) params[0];
        try{
            String uri = RESTConst.getByIdPath(RESTConst.DEPARTMENT_REST_PATH,id);

            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<PhotoArtefact> entity = new HttpEntity<>(headers);
            RestTemplate template = new RestTemplate(true);

            ResponseEntity<DepartmentInfo> responseEntity = template.exchange(uri, HttpMethod.GET, entity, DepartmentInfo.class);

            return responseEntity.getBody();
        } catch (Exception e) {
            Log.e("PhotoArtefact", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(DepartmentInfo artefactL) {
        if (artefactL == null) {
            Toast.makeText(source, "Artifacts data not found, please try again!", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent=new Intent(source, DepartmentActivity.class);
        intent.putExtra("department",(Serializable) artefactL);
        source.startActivity(intent);
    }


}
