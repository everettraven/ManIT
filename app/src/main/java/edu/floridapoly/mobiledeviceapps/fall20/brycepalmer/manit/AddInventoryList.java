package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddInventoryList extends AppCompatActivity {
    private EditText listName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inventory_list);
    }

    public void create_list(View view){
        listName = (EditText) findViewById(R.id.listName);
        Intent intent = new Intent();
        intent.putExtra(PhysicalInventory_Lists.LIST_CREATION_KEY, listName.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancel_list(View view){
        setResult(RESULT_CANCELED);
        finish();
    }

}