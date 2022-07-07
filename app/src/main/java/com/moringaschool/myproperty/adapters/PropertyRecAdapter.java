package com.moringaschool.myproperty.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.myproperty.R;
import com.moringaschool.myproperty.ui.PropertyDetailsActivity;
import com.moringaschool.myproperty.models.Property;

import java.io.Serializable;
import java.util.List;

public class PropertyRecAdapter extends RecyclerView.Adapter<PropertyRecAdapter.myHolder> {

    List<Property> allProperties;
    Context cont;

    public PropertyRecAdapter(List<Property> allProperties, Context cont) {
        this.allProperties = allProperties;
        this.cont = cont;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(cont).inflate(R.layout.property, parent, false);
        return new myHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        holder.setPropertyData(allProperties.get(position));

    }

    @Override
    public int getItemCount() {
        return allProperties.size();
    }

    public class myHolder extends RecyclerView.ViewHolder {

        TextView name, description;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.propertyName);
            description =  itemView.findViewById(R.id.propertyDescription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getLayoutPosition();
                    Intent intent = new Intent(cont, PropertyDetailsActivity.class);
                    intent.putExtra("position", position);
                    intent.putExtra("allProperties", (Serializable) allProperties);
                    cont.startActivity(intent);

                }
            });
        }

        public void setPropertyData(Property property){

            name.setText(property.getProperty_name());
            description.setText("This property belongs to: " + property.getManager_name());

        }
    }
}
