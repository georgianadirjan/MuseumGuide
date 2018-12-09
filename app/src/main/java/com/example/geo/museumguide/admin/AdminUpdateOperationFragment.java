package com.example.geo.museumguide.admin;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geo.museumguide.R;

/**
 * Created by Geo on 1/11/2017.
 */

public class AdminUpdateOperationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.my_profile_layout,container,false);

        return view;}

}
