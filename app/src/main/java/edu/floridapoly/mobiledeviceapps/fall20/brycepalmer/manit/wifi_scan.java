package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class wifi_scan extends AppCompatActivity {

    //Intent newScan_intent = new Intent(wifi_scan.this, new_scan.class);
    //Intent previousScan_intent = new Intent(wifi_scan.this, previous_scan.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_scan);

        //new scan
        Button newScanButton = (Button) findViewById(R.id.newScan_button);
        Button previousScanButton = (Button) findViewById(R.id.previousScan_button);

    }

    public void clicked_newScanButton(View view) {
        Toast.makeText(getApplicationContext(),"Switches to activity to enter a new scan", Toast.LENGTH_LONG).show();
        Intent newScan_intent = new Intent(wifi_scan.this, new_scan.class);
        startActivity(newScan_intent);
    }

    public void clicked_previousScanButton(View view) {
        Toast.makeText(getApplicationContext(),"Shows the map of the last scan", Toast.LENGTH_LONG).show();
        //startActivity(previousScan_intent);
    }

    public void clicked_validate(View view) {
        Intent intent = new Intent(wifi_scan.this, ValidateWAP.class);
        startActivity(intent);
    }

    //new scan
    /*  button to enter new scan ->
        display info
        b - add WAP
        b - save for validation
        b - skip
     */

}