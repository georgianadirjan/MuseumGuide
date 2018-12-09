package com.example.geo.museumguide.admin.department.beacon.show;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geo.museumguide.Beacon;
import com.example.geo.museumguide.R;
import com.example.geo.museumguide.bean.department.BeaconIdentificationBean;
import com.example.geo.museumguide.model.Artefact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geo on 2/6/2017.
 */

public class CustomAdapter extends ArrayAdapter<BeaconIdentificationBean> implements View.OnClickListener {

    private List<BeaconIdentificationBean> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtuuid;
        TextView txtmajor;
        TextView txtminor;

    }

    public CustomAdapter(List<BeaconIdentificationBean> data, Context context) {
        super(context, R.layout.row_item2, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        BeaconIdentificationBean dataModel = (BeaconIdentificationBean) object;

        switch (v.getId()) {
            case R.id.item_info:
                Snackbar.make(v, "Title " + dataModel.getUuid(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        BeaconIdentificationBean dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new CustomAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item2, parent, false);
            viewHolder.txtuuid = (TextView) convertView.findViewById(R.id.uuid_number);
            viewHolder.txtmajor = (TextView) convertView.findViewById(R.id.major_number);
            viewHolder.txtminor = (TextView) convertView.findViewById(R.id.minor_number);


            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtuuid.setText(dataModel.getUuid());
        viewHolder.txtmajor.setText(String.valueOf(dataModel.getMajor()));
        viewHolder.txtminor.setText(String.valueOf(dataModel.getMinor()));


        return convertView;
    }
}
