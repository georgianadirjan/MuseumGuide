package com.example.geo.museumguide.connection.department;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geo.museumguide.department.DepartmentActivity;
import com.example.geo.museumguide.R;
import com.example.geo.museumguide.bean.department.BeaconIdentificationBean;
import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.department.DepartmentInfo;
import com.example.geo.museumguide.department.SingleDepartmentActivity;
import com.example.geo.museumguide.department.task.DepartmentDialog;
import com.example.geo.museumguide.department.task.GetAllDepartmentsTask;
import com.example.geo.museumguide.department.task.GetSingleDepartmentForBeaconTask;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by Geo on 1/28/2017.
 */

public class GetDepartmentByBeaconTask extends AsyncTask<Object, Void, DepartmentInfo> {

    private Activity source;

    public GetDepartmentByBeaconTask(Activity source) {
        this.source = source;
    }

    @Override
    protected DepartmentInfo doInBackground(Object... params) {
        String uuid = (String) params[0];
        Integer major = (Integer) params[1];
        Integer minor = (Integer) params[2];
        BeaconIdentificationBean bean = new BeaconIdentificationBean();
        bean.setMajor(major);
        bean.setMinor(minor);
        bean.setUuid(uuid);
        try {
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<BeaconIdentificationBean> entity = new HttpEntity<BeaconIdentificationBean>(bean, headers);

            String uri = RESTConst.BEACON_DEPARTMENT_REST_PATH;

            ResponseEntity<DepartmentInfo> result = restTemplate.exchange(uri, HttpMethod.POST, entity, DepartmentInfo.class);

            return result.getBody();
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(final DepartmentInfo department) {
        if (department == null) {
            Toast.makeText(source, "Department by beacon not found, please try again!", Toast.LENGTH_LONG).show();
            return;
        }
       /// Toast.makeText(source, "Found! "+department.getName(), Toast.LENGTH_LONG).show();
       // Toast.makeText(source, "Department found!", Toast.LENGTH_LONG).show();
      /*  Intent intent=new Intent(source, DepartmentDialog.class);
        intent.putExtra("depDialog", department);
        source.startActivity(intent);
*/


       showCustomDialog(department);

    }

    protected void showCustomDialog(final DepartmentInfo department1) {
        final Dialog dialog = new Dialog(source);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.department_layout_info);
     //   ImageButton button = (ImageButton) dialog.findViewById(R.id.imagedep);
        ImageButton buttonDep = (ImageButton) dialog.findViewById(R.id.imagedep);
        ImageButton buttonDepDelete = (ImageButton) dialog.findViewById(R.id.imagedepDelete);
        TextView nameDepText = (TextView) dialog.findViewById(R.id.nameDepText);
        TextView beaconIDText = (TextView) dialog.findViewById(R.id.beaconIDtxt);
        TextView descriptionText = (TextView) dialog.findViewById(R.id.detailsDep1Text);
        nameDepText.setText(department1.getName());
        beaconIDText.setText(String.valueOf(department1.getBeaconId()));
        descriptionText.setText(department1.getDetails());
        buttonDepDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();


        buttonDep.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(source, SingleDepartmentActivity.class);
                intent.putExtra("department",department1);
                source.startActivity(intent);
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
