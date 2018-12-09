package com.example.geo.museumguide.admin.user.list;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.model.Artefact;
import com.example.geo.museumguide.model.User;

import java.util.ArrayList;

/**
 * Created by Geo on 2/7/2017.
 */

public class CustomAdapter extends ArrayAdapter<User> implements View.OnClickListener {

    private ArrayList<User> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtFirsname;
        TextView txtLastname;
        TextView txtUsername;
        TextView txtEmail;
        ImageView info;
    }

    public CustomAdapter(ArrayList<User> data, Context context) {
        super(context, R.layout.row_item_user, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        User dataModel = (User) object;

        switch (v.getId()) {
            case R.id.item_info:
                Snackbar.make(v, "Title " + dataModel.getEmail(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final User dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtFirsname = (TextView) convertView.findViewById(R.id.firstnameUser);
            viewHolder.txtLastname = (TextView) convertView.findViewById(R.id.lastnameUser);
            viewHolder.txtUsername = (TextView) convertView.findViewById(R.id.usernameUser);
            viewHolder.txtEmail = (TextView) convertView.findViewById(R.id.emailUser);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_infoUser);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtFirsname.setText(dataModel.getFirstName());
        viewHolder.txtLastname.setText(dataModel.getLastName());
        viewHolder.txtUsername.setText(dataModel.getUserName());
        viewHolder.txtEmail.setText(dataModel.getEmail());
        viewHolder.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String msg="Password: "+dataModel.getPassword();
                AlertDialog dlg = new AlertDialog.Builder(getContext())
                        .setView(R.layout.artefact_info)
                        .setTitle("Details")
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
