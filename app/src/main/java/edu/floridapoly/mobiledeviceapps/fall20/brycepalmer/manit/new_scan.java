package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiInfo;
import androidx.appcompat.app.AppCompatActivity;

public class new_scan extends AppCompatActivity {


    String wapname;
    String SSID;
    int IP;
    String MAC;
    int sigstrength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_scan);
    }
//getSystemService(Context.WIFI_SERVICE);
    public void clicked_scan_WAP(View view) {
        WifiManager manager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();

        EditText wng = (EditText) findViewById(R.id.wap_name_gather);
        wapname = wng.getText().toString();
        sigstrength = info.getRssi();
        MAC = info.getMacAddress();
        IP = info.getIpAddress();
        SSID = info.getSSID();

        Toast.makeText(getApplicationContext(),"stop 1", Toast.LENGTH_LONG).show();
        if (wapname.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Enter a WAP Name Then Try Again stop 2", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"stop 3", Toast.LENGTH_LONG).show();
            TextView name = (TextView) findViewById(R.id.wap_name_holder);
            name.setText(wapname);
            TextView ssid = (TextView) findViewById(R.id.ssid_holder);
            ssid.setText(SSID);
            TextView ip = (TextView) findViewById(R.id.ip_holder);
            ip.setText(String.valueOf(IP));
            TextView mac = (TextView) findViewById(R.id.mac_holder);
            mac.setText(MAC);
            TextView signalstrength = (TextView) findViewById(R.id.signalstrength_holder);
            signalstrength.setText(String.valueOf(sigstrength));
        }

    }
    public void clicked_validate(View view) {
        Toast.makeText(getApplicationContext(),"Option to validate later", Toast.LENGTH_LONG).show();
    }
    public void clicked_skip(View view) {
        Toast.makeText(getApplicationContext(),"Option to skip entry", Toast.LENGTH_LONG).show();
    }
}