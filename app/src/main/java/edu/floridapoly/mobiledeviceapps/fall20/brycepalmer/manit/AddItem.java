package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddItem extends AppCompatActivity {
    private EditText itemName;
    private EditText itemSerialNum;
    private EditText itemDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    public void create_item(View view){
        itemName = (EditText) findViewById(R.id.itemName);
        itemSerialNum = (EditText) findViewById(R.id.serialNum);
        itemDesc = (EditText) findViewById(R.id.itemDesc);
        Intent intent = new Intent();
        intent.putExtra(PhysicalInventory_List_Details.ITEM_NAME_KEY, itemName.getText().toString());
        intent.putExtra(PhysicalInventory_List_Details.ITEM_SERIAL_KEY, itemSerialNum.getText().toString());
        intent.putExtra(PhysicalInventory_List_Details.ITEM_DESC_KEY, itemDesc.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }

}