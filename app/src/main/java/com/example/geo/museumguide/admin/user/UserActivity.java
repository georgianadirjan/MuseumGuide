package com.example.geo.museumguide.admin.user;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.estimote.sdk.SystemRequirementsChecker;
import com.example.geo.museumguide.R;
import com.example.geo.museumguide.admin.department.artefact.add.AddArtefactFragment;
import com.example.geo.museumguide.admin.department.artefact.delete.DeleteArtefactFragment;
import com.example.geo.museumguide.admin.department.artefact.show.ArtefactCrudOperationsActivity;
import com.example.geo.museumguide.admin.department.artefact.show.ArtefactShowList;
import com.example.geo.museumguide.admin.department.artefact.update.UpdateArtefactFragment;
import com.example.geo.museumguide.admin.department.beacon.delete.DeleteBeaconFragment;
import com.example.geo.museumguide.admin.user.add.CreateUserFragment;
import com.example.geo.museumguide.admin.user.delete.DeleteUserFragment;
import com.example.geo.museumguide.admin.user.list.UserListActivity;
import com.example.geo.museumguide.admin.user.update.UpdateUserFragment;

/**
 * Created by Geo on 1/11/2017.
 */

public class UserActivity extends ActionBarActivity {


    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private static final String TAG = "ArtefactCRUDActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_crud_layout);



        mDrawerList = (ListView) findViewById(R.id.navListUser);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layoutUser);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void addDrawerItems() {
        String[] osArray = {"Add User", "Delete User", "Update User", "Show All Users"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(UserActivity.this, "", Toast.LENGTH_SHORT).show();


                switch (position) {
                    case 0:
                        Intent i1 = new Intent(UserActivity.this, CreateUserFragment.class);
                        startActivity(i1);
                        break;
                    case 1:
                        Intent i2 = new Intent(UserActivity.this, DeleteUserFragment.class);
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3 = new Intent(UserActivity.this, UpdateUserFragment.class);
                        startActivity(i3);
                        break;
                    case 3:

                        Intent i4 = new Intent(UserActivity.this, UserListActivity.class);
                        startActivity(i4);
                        break;
                    default:
                }

            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!SystemRequirementsChecker.checkWithDefaultDialogs(this)) {
            Log.e(TAG, "Can't scan for beacons, some pre-conditions were not met");
            Log.e(TAG, "Read more about what's required at: http://estimote.github.io/Android-SDK/JavaDocs/com/estimote/sdk/SystemRequirementsChecker.html");
            Log.e(TAG, "If this is fixable, you should see a popup on the app's screen right now, asking to enable what's necessary");
        } else {
            Log.d(TAG, "Starting ProximityContentManager content updates");
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
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

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

