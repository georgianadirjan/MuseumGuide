package com.example.geo.museumguide.admin.department.beacon.show;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.bean.department.BeaconIdentificationBean;
import com.example.geo.museumguide.model.Artefact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geo on 2/6/2017.
 */

public class BeaconListActivity extends Activity {
    List<BeaconIdentificationBean> dataModels;
    ListView listView;
    private static CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beacon_list);


        listView = (ListView) findViewById(R.id.list6);

        dataModels = new ArrayList<BeaconIdentificationBean>();

        dataModels.add(new BeaconIdentificationBean("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 27221, 7677));
        dataModels.add(new BeaconIdentificationBean("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 43344, 41745));
        dataModels.add(new BeaconIdentificationBean("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 23373, 36365));

        // new GetAllArtefactsTask(ArtefactShowList.this).execute();
        //  dataModels=new GetAllArtefactsTask(ArtefactShowList.this).getArtefacts();

        adapter = new CustomAdapter(dataModels, BeaconListActivity.this);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                BeaconIdentificationBean dataModel = dataModels.get(position);

                Snackbar.make(view, dataModel.getUuid() + "\n" + dataModel.getMajor() + "  " + dataModel.getMinor(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
