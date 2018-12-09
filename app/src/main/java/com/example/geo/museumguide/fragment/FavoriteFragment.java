package com.example.geo.museumguide.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.SimpleAdapter;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.model.ArtefactListItem;

import java.util.ArrayList;

/**
 * Created by Geo on 12/5/2016.
 */

public class FavoriteFragment extends Fragment {

    private ArrayList<ArtefactListItem> artefactList;
    private SimpleAdapter mAdapter;
    public FavoriteFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        artefactList = new ArrayList();
        artefactList.add(new ArtefactListItem("Example 1"));
        artefactList.add(new ArtefactListItem("Example 2"));
        artefactList.add(new ArtefactListItem("Example 3"));
        //mAdapter = new ArtefactListItem(getActivity(), artefactList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fav_fragment_layout,container,false);
        return view;
    }
}
