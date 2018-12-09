package com.example.geo.museumguide.admin.department.artefact.show;

/**
 * Created by Geo on 2/4/2017.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.model.Artefact;
import com.example.geo.museumguide.tour.ArtefactBean;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Artefact> implements View.OnClickListener {

    private List<Artefact> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtTitle;
        TextView txtAuthor;
        TextView txtYear;
        ImageView info;
    }

    public CustomAdapter(List<Artefact> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Artefact dataModel = (Artefact) object;

        switch (v.getId()) {
            case R.id.item_info:
                Snackbar.make(v, "Title " + dataModel.getTitle(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Artefact dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtTitle = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtAuthor = (TextView) convertView.findViewById(R.id.type);
            viewHolder.txtYear = (TextView) convertView.findViewById(R.id.version_number);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtTitle.setText(dataModel.getTitle());
        viewHolder.txtAuthor.setText(dataModel.getAuthor());
        viewHolder.txtYear.setText(String.valueOf(dataModel.getYear()));
        viewHolder.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String msg=dataModel.getDescription();
                AlertDialog dlg = new AlertDialog.Builder(getContext())
                        .setView(R.layout.artefact_info)
                        .setTitle("Description")
                        .setMessage(msg)
                        .setPositiveButton("Ok",new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                //retval = 0;
                                Toast.makeText(getContext(),
                                        msg, Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                dlg.show();
            }
        });
        viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}