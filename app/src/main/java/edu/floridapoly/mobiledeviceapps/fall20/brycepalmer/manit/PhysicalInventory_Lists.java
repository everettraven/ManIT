package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.AppDbRepo;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.InventoryListsListAdapter;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.InventoryListsViewModel;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.Lists;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.OrgListAdapter;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.OrgViewModel;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.Orgs;

public class PhysicalInventory_Lists extends AppCompatActivity {
    private int OrgId;
    private InventoryListsViewModel mListsViewModel;

    public static String LIST_CREATION_KEY = "LIST_CREATE";

    private static int LIST_CREATE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_inventory);

        Intent callerIntent = getIntent();
        OrgId = callerIntent.getIntExtra(Organizations.ORG_ID_KEY, -22);

        // Set up all of our view variables
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        InventoryListsListAdapter adapter = new InventoryListsListAdapter(PhysicalInventory_Lists.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(PhysicalInventory_Lists.this));

        // Set up the view model
        mListsViewModel = new ViewModelProvider(PhysicalInventory_Lists.this).get(InventoryListsViewModel.class);

        // Get all the organizations from the database
        mListsViewModel.getAllLists(OrgId).observe(PhysicalInventory_Lists.this, new Observer<List<Lists>>() {
            @Override
            public void onChanged(@Nullable final List<Lists> lists) {
                // Update all the information when something is changed
                adapter.setLists(lists);
            }
        });

    }

    //Currently just make any list that is clicked go to the same list details page
    public void list_clicked(View view) {
        Intent intent = new Intent(PhysicalInventory_Lists.this, PhysicalInventory_List_Details.class);
        startActivity(intent);
    }

    public void clicked_add(View view) {
        Intent intent = new Intent(this, AddInventoryList.class);
        startActivityForResult(intent, LIST_CREATE_REQUEST_CODE);
    }

    public void clicked_edit(View view) {
        Toast.makeText(this, "Edit clicked, would edit a List.", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode != LIST_CREATE_REQUEST_CODE){
            return;
        }

        if(resultCode == Activity.RESULT_OK){
            if(data != null)
            {
                Lists list = new Lists();
                list.setOrgID(OrgId);
                list.setName(data.getStringExtra(LIST_CREATION_KEY));
                mListsViewModel.insert(list);
            }
        }

        return;
    }
}