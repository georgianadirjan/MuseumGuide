package com.example.geo.museumguide.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.geo.museumguide.admin.AdminActivity;
import com.example.geo.museumguide.R;
import com.example.geo.museumguide.admin.user.update.UpdateLoggedUserFragment;
import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.constante.FRAGMENTTag;

/**
 * Created by Geo on 1/8/2017.
 */

public class MyProfileFragment extends Fragment implements View.OnClickListener {

    private TextView firstName;
    private TextView lastName;
    private TextView username;
    private TextView password;
    private ImageButton updateBtn;
    private ImageButton adminBtn;
    private TextView email;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_profile_layout, container, false);

        firstName = (TextView) view.findViewById(R.id.firstnamePf);
        lastName = (TextView) view.findViewById(R.id.lastnamePf);
        username = (TextView) view.findViewById(R.id.usernamePf);
        password = (TextView) view.findViewById(R.id.passwordPf);
        email = (TextView) view.findViewById(R.id.emailPf);

        updateBtn = (ImageButton) view.findViewById(R.id.updateBtn);
        adminBtn = (ImageButton) view.findViewById(R.id.adminBtn);

       firstName.setText(LogInService.getLoggedUser().getFirstName());
        lastName.setText(LogInService.getLoggedUser().getLastName());
        username.setText(LogInService.getLoggedUser().getUserName());
        password.setText(LogInService.getLoggedUser().getPassword());
        email.setText(LogInService.getLoggedUser().getPassword());

       /* firstName.setText("");
        lastName.setText("");
        username.setText("");
        password.setText("");
        email.setText("");
*/

        updateBtn.setOnClickListener(this);


        adminBtn.setOnClickListener(this);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(FRAGMENTTag.MY_PROFILE_TAG);
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.updateBtn:
                // replaceFragment(getActivity().getSupportFragmentManager().findFragmentById(R.id.update_fragment_id));
               // FragmentManager fragmentManager2 = getFragmentManager();
               // FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                UpdateLoggedUserFragment fragment2 = new UpdateLoggedUserFragment();
                Intent i= new Intent(getActivity(),UpdateLoggedUserFragment.class);
                startActivity(i);
                /*fragmentTransaction2.addToBackStack("xyz");
                fragmentTransaction2.hide(MyProfileFragment.this);
                fragmentTransaction2.add(R.id.my_profile_layout_id, fragment2);
                fragmentTransaction2.commit();
                */
                break;

            case R.id.adminBtn:
                Intent adminIntent = new Intent(getActivity(), AdminActivity.class);
                startActivity(adminIntent);
                break;
        }
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.update_fragment_id, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
