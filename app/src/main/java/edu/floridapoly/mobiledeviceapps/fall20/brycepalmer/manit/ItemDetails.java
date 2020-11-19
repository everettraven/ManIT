package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetails extends AppCompatActivity {

    private String itemName;
    private String itemSerialNum;
    private String itemDesc;

    private TextView itemDetailName;
    private TextView itemDetailSerialNum;
    private TextView itemDetailDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        Intent intent = getIntent();
        itemName = intent.getExtras().getString(PhysicalInventory_List_Details.ITEM_NAME_KEY);
        itemSerialNum = intent.getExtras().getString(PhysicalInventory_List_Details.ITEM_SERIAL_KEY);
        itemDesc = intent.getExtras().getString(PhysicalInventory_List_Details.ITEM_DESC_KEY);

        itemDetailName = (TextView) findViewById(R.id.itemDetailName);
        itemDetailSerialNum = (TextView) findViewById(R.id.itemDetailSerialNum);
        itemDetailDesc = (TextView) findViewById(R.id.itemDetailDesc);

        itemDetailName.setText(itemName);
        itemDetailSerialNum.setText(itemSerialNum);
        itemDetailDesc.setText(itemDesc);
    }

}