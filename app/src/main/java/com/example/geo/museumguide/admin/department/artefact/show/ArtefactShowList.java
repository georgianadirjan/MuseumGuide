package com.example.geo.museumguide.admin.department.artefact.show;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.connection.artefact.GetAllArtefactsTask;
import com.example.geo.museumguide.model.Artefact;
import com.example.geo.museumguide.tour.ArtefactBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geo on 2/6/2017.
 */

public class ArtefactShowList  extends Activity {

        List<Artefact> dataModels;
        ListView listView;
        private static CustomAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.artefact_list);

            listView=(ListView)findViewById(R.id.list5);

            dataModels=(List) getIntent().getSerializableExtra("artefactList");

          /*  dataModels.add(new Artefact("Salvador Dali","The Persistence Of Memory",1931,"description 1"));
            dataModels.add(new Artefact("Mona Lisa", "Leonardo Da Vinci", 1503, "description 2"));
            dataModels.add(new Artefact("The Night Watch", "Rembrandt van Rijn", 1642, "description 3"));
            dataModels.add(new Artefact("Guernica", "Pablo Picasso", 1937, "description 4"));
            dataModels.add(new Artefact("Girl With A Pearl Earring", "Johannes Vermeer", 1665, "description 3"));
*/
         //   new (ArtefactShowList.this).execute();

            adapter= new CustomAdapter(dataModels,ArtefactShowList.this);

            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Artefact dataModel= dataModels.get(position);

                    Snackbar.make(view, dataModel.getTitle()+"\n"+dataModel.getAuthor()+"  "+dataModel.getYear(), Snackbar.LENGTH_LONG)
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
