package com.example.geo.museumguide.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.constante.FRAGMENTTag;

/**
 * Created by Geo on 1/6/2017.
 */

public class AboutAppFragment extends Fragment {

    public AboutAppFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.about_app_layout,container,false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(FRAGMENTTag.ABOUT_APP_TAG);
    }
}
