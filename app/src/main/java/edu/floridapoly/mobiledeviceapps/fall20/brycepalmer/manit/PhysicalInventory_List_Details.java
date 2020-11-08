package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.InventoryListsListAdapter;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.InventoryListsViewModel;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.Items;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.ItemsListAdapter;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.ItemsViewModel;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.Lists;

public class PhysicalInventory_List_Details extends AppCompatActivity {
    private int ListId;
    private ItemsViewModel mItemsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_inventory__list__details);

        Intent callerIntent = getIntent();
        ListId = callerIntent.getIntExtra("ListID", -22);
        TextView title = (TextView) findViewById(R.id.listTitle);
        title.setText(callerIntent.getStringExtra("List"));

        // Set up all of our view variables
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        ItemsListAdapter adapter = new ItemsListAdapter(PhysicalInventory_List_Details.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(PhysicalInventory_List_Details.this));

        // Set up the view model
        mItemsViewModel = new ViewModelProvider(PhysicalInventory_List_Details.this).get(ItemsViewModel.class);

        // Get all the organizations from the database
        mItemsViewModel.getAllItems(ListId).observe(PhysicalInventory_List_Details.this, new Observer<List<Items>>() {
            @Override
            public void onChanged(@Nullable final List<Items> items) {
                // Update all the information when something is changed
                adapter.setItems(items);
            }
        });

    }

    public void clicked_add(View view) {
        Items item = new Items();
        item.setName("Test Item");
        item.setListID(ListId);
        mItemsViewModel.insert(item);
        Toast.makeText(this, "Add button was clicked, this would add a new item to the list", Toast.LENGTH_LONG).show();
    }
}