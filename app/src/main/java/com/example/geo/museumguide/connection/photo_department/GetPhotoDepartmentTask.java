package com.example.geo.museumguide.connection.photo_department;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.connection.photo_artefact.PhotoArtefact;
import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.events.ExpoRecyclerViewActivity;
import com.example.geo.museumguide.gallery.GalleryActivity;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Geo on 2/8/2017.
 */

public class GetPhotoDepartmentTask extends AsyncTask<Object, Void, List<PhotoDepartment>> {

    private Activity source;
    private ArrayList<PhotoDepartment> departments;

    public GetPhotoDepartmentTask(Activity source) {
        this.source = source;
        departments = new ArrayList<PhotoDepartment>();
    }

    public GetPhotoDepartmentTask() {

    }

    public ArrayList<PhotoDepartment> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<PhotoDepartment> departments) {
        this.departments = departments;
    }

    @Override
    protected List<PhotoDepartment> doInBackground(Object... params) {
        Integer id = null;
        if(params!=null && params.length==1){
            id = (Integer) params[0];
        }

        try {
           /*
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<User> entity = new HttpEntity<User>(headers);
*/
           String uri = RESTConst.FOTO_DEPARTMENT_PATH;
           if(id!=null){
               uri= RESTConst.getByIdPath(RESTConst.FOTO_DEPARTMENT_BY_DEPARTMENT_PATH,id);
           }

            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<PhotoArtefact> entity = new HttpEntity<>(headers);

            // ResponseEntity<List<Artefact>> res = restTemplate.postForEntity(uri, entity, new ParameterizedTypeReference<List<Artefact>>() {});

            //  ResponseEntity<? extends ArrayList<Artefact>> responseEntity = restTemplate.getForEntity(uri, (Class<? extends ArrayList<Artefact>>)ArrayList.class, id);
            RestTemplate template = new RestTemplate(true);


            ResponseEntity<PhotoDepartment[]> responseEntity = template.exchange(uri, HttpMethod.GET, entity, PhotoDepartment[].class);

            List<PhotoDepartment> ar = Arrays.asList(responseEntity.getBody());
            this.departments.addAll(ar);
            return ar;
            // return  restTemplate.postForObject(uri,  HttpMethod.POST,null, new  FakeParameterizedTypeReference<ResponseWrapper<Artefact>>());
        } catch (Exception e) {
            Log.e("PhotoArtefact", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<PhotoDepartment> departments) {
        if (departments == null) {
            Toast.makeText(source, "Departments not found, please try again!", Toast.LENGTH_LONG).show();
            return;
        }

        ArrayList<PhotoDepartment> photoDepartments= new ArrayList<PhotoDepartment>();
        photoDepartments.addAll(departments);
        Intent intent=new Intent(source, ExpoRecyclerViewActivity.class);
        intent.putExtra("departmentList", photoDepartments);
        source.startActivity(intent);

    }


}
