package com.moringaschool.myproperty.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.myproperty.fragments.PropertyFragment;
import com.moringaschool.myproperty.models.Property;

import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {
    List<Property> allProperties;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior, List<Property> allProperties) {
        super(fm, behavior);
        this.allProperties = allProperties;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        PropertyFragment fragment = PropertyFragment.newInstance(allProperties.get(position));
        return fragment;
    }

    @Override
    public int getCount() {
        return allProperties.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return allProperties.get(position).getProperty_name();
    }
}
