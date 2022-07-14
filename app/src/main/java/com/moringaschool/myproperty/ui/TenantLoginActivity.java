package com.moringaschool.myproperty.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.myproperty.R;
import com.moringaschool.myproperty.databinding.ActivityTenantLoginBinding;
import com.moringaschool.myproperty.models.Constants;

public class TenantLoginActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityTenantLoginBinding tenantBinding;
    DatabaseReference ref;
    SharedPreferences pref;
    SharedPreferences.Editor prefEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tenantBinding = ActivityTenantLoginBinding.inflate(getLayoutInflater());
        setContentView(tenantBinding.getRoot());

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        prefEditor = pref.edit();
        ref = FirebaseDatabase.getInstance().getReference().child("Tenants");
        tenantBinding.login.setOnClickListener(this);

        //AUTHENTICATE TENANT
        //START NEW INTENT IF SUCCESSFULL

    }

    @Override
    public void onClick(View v) {
        if (v == tenantBinding.login){

            String tenantEmail = tenantBinding.userEmail.getEditText().getText().toString().trim();
            String tenantPassword = tenantBinding.password.getEditText().getText().toString().trim();

            Query query = ref.orderByChild("tenant_id").equalTo(tenantPassword);

            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()){

                        String emailFromDb = snapshot.child(tenantPassword).child("tenant_email").getValue(String.class);
                        String tenantId = snapshot.child(tenantPassword).child("tenant_id").getValue(String.class);
                        String propertyName = snapshot.child(tenantPassword).child("property_name").getValue(String.class);
                        String unitName = snapshot.child(tenantPassword).child("unit_name").getValue(String.class);
                        String tenantName = snapshot.child(tenantPassword).child("tenant_name").getValue(String.class);
                        String managerName = snapshot.child(tenantPassword).child("manager_name").getValue(String.class);

                        if (tenantEmail.equals(emailFromDb) && tenantPassword.equals(tenantId)){

                            prefEditor.putString(Constants.TENANT_ID, tenantId).apply();
                            prefEditor.putString(Constants.PROPERTY_NAME, propertyName).apply();
                            prefEditor.putString(Constants.UNIT_NAME, unitName).apply();
                            prefEditor.putString(Constants.TENANT_NAME, tenantName).apply();
                            prefEditor.putString(Constants.DEFECT_MANAGER_NAME, managerName).apply();

                            Intent intent = new Intent(TenantLoginActivity.this, TenantMainActivity.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(TenantLoginActivity.this, "Please check your credentials and login again", Toast.LENGTH_SHORT).show();
                        }

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }

    }
}