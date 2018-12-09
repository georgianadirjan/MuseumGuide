package com.example.geo.museumguide.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ZoomButton;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.constante.FRAGMENTTag;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Geo on 1/8/2017.
 */

public class MapFragment extends Fragment implements  OnMapReadyCallback{

    private MapView mapView;
    private GoogleMap googleMap;
    private boolean mapsSupported = true;
    //46.770018906739814, 23.5901953739068

    public MapFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_fragment, container, false);


        /*
        SupportMapFragment supportMapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.mapView);

         mapFragment.getMapAsync(this);

        SupportMapFragment supportMapFragment;
        if (Build.VERSION.SDK_INT < 21) {
            supportMapFragment = (SupportMapFragment) getActivity()
                    .getSupportFragmentManager().findFragmentById(R.id.mapView);
        } else {
            supportMapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.mapView);
        }
        supportMapFragment.getMapAsync(this);
  */



        return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mapView = (MapView) view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);//when you already implement OnMapReadyCallback in your fragment
          }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap = googleMap;

        LatLng currentLocation=new LatLng(46.770018906739814, 23.5901953739068);

        Marker marker = googleMap.addMarker(new MarkerOptions()
                .position(currentLocation)
                .title("Bánffy Palace"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,15));
        // Zoom in, animating the camera.
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
    }
}


