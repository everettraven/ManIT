package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PhysicalInventory_List_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_inventory__list__details);
    }

    public void item_clicked(View view) {
        Toast.makeText(this, "Item was clicked, this would perform our animation to show more details about the item.", Toast.LENGTH_LONG).show();
    }


    public void clicked_add(View view) {
        Toast.makeText(this, "Add button was clicked, this would add a new item to the list", Toast.LENGTH_LONG).show();
    }
}