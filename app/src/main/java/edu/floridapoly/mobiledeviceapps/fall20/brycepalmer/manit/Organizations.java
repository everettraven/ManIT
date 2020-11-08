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
        Orgs org_to_add = new Orgs("Jimbos Garage");
        mOrgViewModel.insert(org_to_add);
        Toast.makeText(this, "Add Action was clicked. This would add a new organization", Toast.LENGTH_LONG).show();
    }

    public void clicked_edit(View view) {
        Toast.makeText(this, "Edit Action was clicked. This would allow editing of an organization", Toast.LENGTH_LONG).show();
    }
}