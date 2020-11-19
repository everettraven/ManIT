package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class wifi_scan extends AppCompatActivity {

    private int OrgID;
    //Intent newScan_intent = new Intent(wifi_scan.this, new_scan.class);
    //Intent previousScan_intent = new Intent(wifi_scan.this, previous_scan.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_scan);

        OrgID = getIntent().getExtras().getInt(Organizations.ORG_ID_KEY);

        //new scan
        Button newScanButton = (Button) findViewById(R.id.newScan_button);
        Button previousScanButton = (Button) findViewById(R.id.previousScan_button);

    }

    public void clicked_newScanButton(View view) {
        Intent newScan_intent = new Intent(wifi_scan.this, new_scan.class);
        newScan_intent.putExtra(Organizations.ORG_ID_KEY, OrgID);
        startActivity(newScan_intent);
    }

    public void clicked_previousScanButton(View view) {
        Intent wapmap_intent = new Intent(wifi_scan.this, WiFiMapsActivity.class);
        //startActivity(previousScan_intent);
    }

    public void clicked_validate(View view) {
        Intent intent = new Intent(wifi_scan.this, ValidateWAP.class);
        intent.putExtra(Organizations.ORG_ID_KEY, OrgID);
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