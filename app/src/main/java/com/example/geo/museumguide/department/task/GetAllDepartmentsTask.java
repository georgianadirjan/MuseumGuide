package com.example.geo.museumguide.department.task;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.admin.department.artefact.show.ArtefactShowList;
import com.example.geo.museumguide.connection.photo_artefact.PhotoArtefact;
import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.department.DepartmentActivity;
import com.example.geo.museumguide.department.DepartmentInfo;
import com.example.geo.museumguide.gallery.GalleryActivity;
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
 * Created by Geo on 2/11/2017.
 */

public class GetAllDepartmentsTask extends AsyncTask<Void, Void, List<DepartmentInfo>> {

    private Activity source;
    private ArrayList<DepartmentInfo> departmentInfos;

    public GetAllDepartmentsTask(Activity source) {
        this.source = source;
        departmentInfos = new ArrayList<DepartmentInfo>();
    }

    public GetAllDepartmentsTask() {

    }

    public ArrayList<DepartmentInfo> getArtefacts() {
        return departmentInfos;
    }

    public void setArtefacts(ArrayList<PhotoArtefact> artefacts) {
        this.departmentInfos = departmentInfos;
    }

    @Override
    protected List<DepartmentInfo> doInBackground(Void... params) {

        try{
            String uri = RESTConst.DEPARTMENT_REST_PATH;

            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<PhotoArtefact> entity = new HttpEntity<>(headers);
            RestTemplate template = new RestTemplate(true);

            ResponseEntity<DepartmentInfo[]> responseEntity = template.exchange(uri, HttpMethod.GET, entity, DepartmentInfo[].class);

            return Arrays.asList(responseEntity.getBody());
        } catch (Exception e) {
            Log.e("PhotoArtefact", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<DepartmentInfo> artefactL) {
        if (artefactL == null) {
            Toast.makeText(source, "Artifacts data not found, please try again!", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent=new Intent(source.getApplicationContext(), DepartmentActivity.class);
        intent.putExtra("departmentList",(Serializable) artefactL);
        source.getApplicationContext().startActivity(intent);
    }


}
