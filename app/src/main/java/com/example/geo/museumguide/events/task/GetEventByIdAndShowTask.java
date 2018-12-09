package com.example.geo.museumguide.events.task;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.events.Event;
import com.example.geo.museumguide.model.User;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by Geo on 2/2/2017.
 */

public class GetEventByIdAndShowTask extends AsyncTask<Object, Void, PhotoDepartmentBean> {

    private Activity source;

    public GetEventByIdAndShowTask(Activity source) {
        this.source = source;
    }

    public GetEventByIdAndShowTask(){

    }

    @Override
    protected PhotoDepartmentBean doInBackground(Object... params) {
        Long id=(Long) params[0] ;
         String name  = (String) params[1];
         String description=  (String) params[2];
         String date=(String) params[3];
         String path=(String) params[4];
        PhotoDepartmentBean event =new PhotoDepartmentBean();
        event.setName(name);
        event.setDescription(description);
        event.setDate(date);
        event.setPath(path);


        try {
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<User> entity = new HttpEntity<User>(headers);

            String uri = RESTConst.getByIdPath(RESTConst.FOTO_DEPARTMENT_PATH, id);

            ResponseEntity<PhotoDepartmentBean> result = restTemplate.exchange(uri, HttpMethod.GET, entity, PhotoDepartmentBean.class);

            return result.getBody();
        } catch (Exception e) {
            Log.e("PhotoDepartmentBean", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(PhotoDepartmentBean event) {
        if(event==null){
            Toast.makeText(source, "Exhibition-Event not found, please try again!", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(source, "Exhibition-Event  found!", Toast.LENGTH_LONG).show();
       /* Toast.makeText(source, "Artifact found!", Toast.LENGTH_LONG).show();
        Intent intent=new Intent(source, NFCTourActivity.class);
        intent.putExtra("event", event);
        source.startActivity(intent);*/
    }
}

