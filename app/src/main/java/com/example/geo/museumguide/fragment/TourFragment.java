package com.example.geo.museumguide.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.constante.FRAGMENTTag;

/**
 * Created by Geo on 12/5/2016.
 */

public class TourFragment extends Fragment {

    public TourFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.tour_fragment_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(FRAGMENTTag.TOUR_TAG);
    }
}
