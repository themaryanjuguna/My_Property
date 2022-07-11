package com.moringaschool.myproperty.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moringaschool.myproperty.databinding.FragmentPropertyBinding;
import com.moringaschool.myproperty.models.Property;


public class PropertyFragment extends Fragment {
    Property property;
    FragmentPropertyBinding fragBind;



    public PropertyFragment() {
        // Required empty public constructor
    }


    public static PropertyFragment newInstance(Property property) {
        PropertyFragment fragment = new PropertyFragment();
        Bundle args = new Bundle();
        args.putSerializable("property", property);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            property = (Property) getArguments().getSerializable("property");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragBind = FragmentPropertyBinding.inflate(inflater, container ,false);
        View v  = fragBind.getRoot();
        fragBind.questName.setText(property.getProperty_name());
        fragBind.questInco.setText(property.getManager_name());

        fragBind.addTenant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getParentFragmentManager();
                TenantDialogFragment fragment = new TenantDialogFragment();

                Bundle args = new Bundle();
                args.putSerializable("property" , property);
                fragment.setArguments(args);

                fragment.show(getParentFragmentManager(),"Tenant Dialog");
            }
        });
        return v;
    }
}