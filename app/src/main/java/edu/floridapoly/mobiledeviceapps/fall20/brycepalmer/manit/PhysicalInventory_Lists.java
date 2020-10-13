package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PhysicalInventory_Lists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_inventory);
    }

    //Currently just make any list that is clicked go to the same list details page
    public void list_clicked(View view) {
        Intent intent = new Intent(PhysicalInventory_Lists.this, PhysicalInventory_List_Details.class);
        startActivity(intent);
    }

    public void clicked_add(View view) {
        Toast.makeText(this, "Add clicked, would add a new List.", Toast.LENGTH_LONG).show();
    }

    public void clicked_edit(View view) {
        Toast.makeText(this, "Edit clicked, would edit a List.", Toast.LENGTH_LONG).show();
    }
}