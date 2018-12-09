package com.example.geo.museumguide;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.estimote.sdk.EstimoteSDK;
import com.estimote.sdk.cloud.model.Color;
import com.example.geo.museumguide.beacon.BeaconID;
import com.example.geo.museumguide.beacon.EstimoteCloudBeaconDetails;
import com.example.geo.museumguide.beacon.EstimoteCloudBeaconDetailsFactory;
import com.example.geo.museumguide.beacon.ProximityContentManager;
import com.example.geo.museumguide.connection.department.GetDepartmentByBeaconTask;
import com.example.geo.museumguide.connection.photo_artefact.GetPhotoArtefactTask;
import com.example.geo.museumguide.connection.photo_department.GetPhotoDepartmentTask;
import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.favorite.task.GetAllFavoritesArtefactsTask;
import com.example.geo.museumguide.favorite.task.GetFavoritePhotoArtefactTask;
import com.example.geo.museumguide.fragment.AboutAppFragment;
import com.example.geo.museumguide.fragment.MainFragment;
import com.example.geo.museumguide.fragment.MapFragment;
import com.example.geo.museumguide.fragment.MyProfileFragment;
import com.example.geo.museumguide.nfc.TourActivity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private static final String BEACON_PROX_UUID="B9407F30-F5F8-466E-AFF9-25556B57FE6D";
    private static final Map<Color, Integer> BACKGROUND_COLORS = new HashMap<>();
    private String minorValue;
    private String beaconInfo;
    private static final int BACKGROUND_COLOR_NEUTRAL = android.graphics.Color.rgb(160, 169, 172);
    private ProximityContentManager proximityContentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EstimoteSDK.initialize(getApplicationContext(), "museumaudioguide-ovz", "27b6dd9e10ce4fc96ad81b6dfbac148e");

     /*   MainFragment mf=new MainFragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,mf);
        */

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //add this line to display menu1 when the activity is loaded
        displaySelectedScreen(10);


        proximityContentManager = new ProximityContentManager(this,
                Arrays.asList(
                        new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 27221, 7677),
                        new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 43344, 41745),
                        new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 23373, 36365)),

                new EstimoteCloudBeaconDetailsFactory());
        proximityContentManager.setListener(new ProximityContentManager.Listener() {
            @Override
            public void onContentChanged(Object content) {
                String text;
                Integer backgroundColor;
                if (content != null) {
                    EstimoteCloudBeaconDetails beaconDetails = (EstimoteCloudBeaconDetails) content;
                    text = "You're in " + beaconDetails.getBeaconName() + "'s range!" + " minor value: " + beaconDetails.getMinor();
                    backgroundColor = BACKGROUND_COLORS.get(beaconDetails.getBeaconColor());
                    //getInfoFromParse(String.valueOf(beaconDetails.getMinor()));

                    new GetDepartmentByBeaconTask(HomeActivity.this).
                            execute(beaconDetails.getUuid(), beaconDetails.getMajor(), beaconDetails.getMinor());

                    createNotification();
                } else {
                    text = "No beacons in range.";
                    backgroundColor = null;
                }
                ((TextView) findViewById(R.id.textView)).setText(text);
                Toast.makeText(HomeActivity.this,text,Toast.LENGTH_LONG).show();
                //findViewById(R.id.relativeLayout).setBackgroundColor(
                  //      backgroundColor != null ? backgroundColor : BACKGROUND_COLOR_NEUTRAL);
            }
        });
    }

    public void createNotification() {
        // Prepare intent which is triggered if the
        // notification is selected
        Intent intent = new Intent(this, HomeActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        // Build notification
        // Actions are just fake
        Notification noti = new Notification.Builder(this)
                .setContentTitle("You have entered a new gallery")
                .setContentText("Exhibition 1").setSmallIcon(R.drawable.ic_artfacts)
                .setContentIntent(pIntent)
                .addAction(R.drawable.ic_exhibition, "And more", pIntent).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        displaySelectedScreen(item.getItemId());
        return true;
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_tour:
               // fragment = new MainFragment();
                Intent n=new Intent(this,TourActivity.class);
                startActivity(n);
                break;
            case R.id.nav_Gallery:
                new GetPhotoArtefactTask(this).execute();
                break;
            case R.id.nav_exhibition:
               // Intent expo=new Intent(this,ExpoRecyclerViewActivity.class);
               // startActivity(expo);
                new GetPhotoDepartmentTask(HomeActivity.this).execute();
                break;
            case R.id.nav_favorite:
                new GetFavoritePhotoArtefactTask(HomeActivity.this).execute();
            case R.id.nav_profile:
                fragment = new MyProfileFragment();
                break;
            case R.id.nav_log_out:
                LogInService.logOut();
                //fragment = new LoginFragment();
                Intent firstPage=new Intent(this,MainActivity.class);
                startActivity(firstPage);
                break;
            case R.id.nav_map:
                fragment = new MapFragment();
                break;

            case R.id.nav_about_app:
                fragment = new AboutAppFragment();

                break;
            default: fragment=new MainFragment();

        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft=getFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Stopping ProximityContentManager content updates");
        proximityContentManager.stopContentUpdates();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Starting ProximityContentManager content updates");
        proximityContentManager.startContentUpdates();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        proximityContentManager.destroy();

    }




}
