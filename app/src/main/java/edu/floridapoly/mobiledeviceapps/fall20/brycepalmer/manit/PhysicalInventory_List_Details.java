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
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.Orgs;

public class PhysicalInventory_List_Details extends AppCompatActivity {
    private int ListId;
    private ItemsViewModel mItemsViewModel;

    public static String ITEM_NAME_KEY = "ITEM_NAME";
    public static String ITEM_SERIAL_KEY = "ITEM_SERIAL";
    public static String ITEM_DESC_KEY = "ITEM_DESC";

    private static int ITEM_CREATE_REQUEST_CODE = 2;

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
        Intent intent = new Intent(this, AddItem.class);
        startActivityForResult(intent, ITEM_CREATE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode != ITEM_CREATE_REQUEST_CODE){
            return;
        }

        if(resultCode == Activity.RESULT_OK){
            if(data != null)
            {
                Items item = new Items();
                item.setListID(ListId);
                item.setSerialNumber(data.getStringExtra(ITEM_SERIAL_KEY));
                item.setDescription(data.getStringExtra(ITEM_DESC_KEY));
                item.setName(data.getStringExtra(ITEM_NAME_KEY));
                mItemsViewModel.insert(item);
            }
        }

        return;
    }
}