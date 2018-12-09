package com.example.geo.museumguide.admin.user.list;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.geo.museumguide.R;

import com.example.geo.museumguide.model.User;

import java.util.ArrayList;

/**
 * Created by Geo on 2/7/2017.
 */

public class UserListActivity extends Activity {

    ArrayList<User> dataModels;
    ListView listView;
    private static CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);


        listView=(ListView)findViewById(R.id.list7);

        dataModels= new ArrayList<User>();

        dataModels.add(new User("ana","pop","ana92","pass"));
        dataModels.add(new User("ana","pop","ana92","pass"));
        dataModels.add(new User("ana","pop","ana92","pass"));


        // new GetAllArtefactsTask(ArtefactShowList.this).execute();
        //  dataModels=new GetAllArtefactsTask(ArtefactShowList.this).getArtefacts();

        adapter= new CustomAdapter(dataModels,UserListActivity.this);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                User dataModel= dataModels.get(position);

                Snackbar.make(view, dataModel.getFirstName()+"\n"+dataModel.getLastName()+"  "+dataModel.getUserName(), Snackbar.LENGTH_LONG)
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
