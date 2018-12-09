package com.example.geo.museumguide.connection.department;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.model.Department;
import com.example.geo.museumguide.model.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Geo on 1/11/2017.
 */

public class CreateDepartmentTask  extends AsyncTask<Void, Void, Department> {

    private Department bean;
    private Activity source;

    public CreateDepartmentTask(Department bean, Activity source) {
        this.bean = bean;
        this.source = source;
    }

    public CreateDepartmentTask(Department bean) {
        this.bean = bean;
    }

    @Override
    protected Department doInBackground(Void... params) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Department result = restTemplate.postForObject(RESTConst.USER_REST_PATH, bean, Department.class);
            return result;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Department user) {
        if (user != null) {
            Toast.makeText(source, "Department created!", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(source, "Neh", Toast.LENGTH_LONG).show();
        }
    }
}
