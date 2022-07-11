package com.moringaschool.myproperty.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.Intent;
import android.os.Bundle;

import com.moringaschool.myproperty.databinding.ActivityPropertyDetailsBinding;
import com.moringaschool.myproperty.adapters.PagerAdapter;
import com.moringaschool.myproperty.models.Property;

import java.util.ArrayList;
import java.util.List;

public class PropertyDetailsActivity extends AppCompatActivity {
    ActivityPropertyDetailsBinding propertyBind;
    List<Property> allProperties;
    PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        propertyBind = ActivityPropertyDetailsBinding.inflate(getLayoutInflater());
        setContentView(propertyBind.getRoot());

        allProperties = new ArrayList<>();
        Intent intent = getIntent();
        allProperties  = (List<Property>) intent.getSerializableExtra("allProperties");
        int position = intent.getIntExtra("position", 0);
        adapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,allProperties);
        propertyBind.viewPager.setAdapter(adapter);
        propertyBind.viewPager.setCurrentItem(position);


    }
}