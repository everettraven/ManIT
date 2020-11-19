package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.annotation.Nullable;
//import android.net.wifi.ScanResult;
//import android.net.wifi.WifiManager;
//import android.net.wifi.WifiInfo;
//import com.google.mlkit:barcode-scanning:16.0.3;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.AppDatabase;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.AppDatabase_Impl;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.AppDbRepo;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.OrgListAdapter;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.OrgViewModel;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.Orgs;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.OrgsDao;

public class Organizations extends AppCompatActivity {
    // Create a variable to hold the View Model for this particular view
    private OrgViewModel mOrgViewModel;

    public static String ORG_ID_KEY = "ORG_ID";
    public static String ORG_CREATION_KEY = "ORG_CREATE";

    public static int ORG_CREATE_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up all of our view variables
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        OrgListAdapter adapter = new OrgListAdapter(Organizations.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Organizations.this));

        // Set up the view model
        mOrgViewModel = new ViewModelProvider(Organizations.this).get(OrgViewModel.class);

        // Get all the organizations from the database
        mOrgViewModel.getAllOrgs().observe(Organizations.this, new Observer<List<Orgs>>() {
            @Override
            public void onChanged(@Nullable final List<Orgs> orgs) {
                // Update all the information when something is changed
                adapter.setOrgs(orgs);
            }
        });
    }

    public void clicked_add(View view) {
        // Test adding a new organization -- Keeping it here to show how we add a new value
        Intent intent = new Intent(this, AddOrganization.class);
        startActivityForResult(intent, ORG_CREATE_REQUEST_CODE);
    }

    public void clicked_edit(View view) {
        Toast.makeText(this, "Edit Action was clicked. This would allow editing of an organization", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode != ORG_CREATE_REQUEST_CODE){
            return;
        }

        if(resultCode == Activity.RESULT_OK){
            if(data != null)
            {
                Orgs org = new Orgs(data.getStringExtra(ORG_CREATION_KEY));
                mOrgViewModel.insert(org);
            }
        }

        return;
    }
}