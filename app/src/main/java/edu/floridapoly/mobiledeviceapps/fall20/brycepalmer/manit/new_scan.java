package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.DhcpInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Formatter;

import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.AppDbRepo;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.WAPS;

public class new_scan extends AppCompatActivity {

    private int OrgID;
    String wapname;
    String SSID;
    int IP;
    String MAC;
    int sigstrength;

    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_scan);

        OrgID = getIntent().getExtras().getInt(Organizations.ORG_ID_KEY);
    }

    //getSystemService(Context.WIFI_SERVICE);
    public void clicked_scan_WAP(View view) {
        WifiManager manager = (WifiManager) super.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();

        LocationManager locman = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(),"Turn your GPS ON!!!", Toast.LENGTH_LONG).show();
            return;
        }
        Location location = locman.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        EditText wng = (EditText) findViewById(R.id.wap_name_gather);
        wapname = wng.getText().toString();
        sigstrength = info.getRssi();
        MAC = info.getBSSID();
        IP = manager.getDhcpInfo().serverAddress;
        SSID = info.getSSID();
        latitude = location.getLatitude();
        longitude = location.getLongitude();

        //signal strength strings
        String Excellent = "Excellent"; // >-50
        String Good = "Good"; // -50 t0 -60 <
        String Fair = "Fair"; // -60 to -70 <
        String Weak = "Weak"; // -70 and greater

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
            ip.setText(android.text.format.Formatter.formatIpAddress(IP));
            TextView mac = (TextView) findViewById(R.id.mac_holder);
            mac.setText(MAC);
            TextView longi = (TextView) findViewById(R.id.longitude_holder);
            longi.setText(String.valueOf(longitude));
            TextView lati = (TextView) findViewById(R.id.latitude_holder);
            lati.setText(String.valueOf(latitude));
            TextView signalstrength = (TextView) findViewById(R.id.signalstrength_holder);
            if(sigstrength > -50)
            {
                signalstrength.setText(Excellent);
            }
            else if( sigstrength <= -50 || sigstrength > -60)
            {
                signalstrength.setText(Good);
            }
            else if( sigstrength <= -60 || sigstrength > -70)
            {
                signalstrength.setText(Fair);
            }
            else if( sigstrength <= -70)
            {
                signalstrength.setText(Weak);
            }

        }

    }
    public void clicked_save(View view) {

        AppDbRepo dbRepo = new AppDbRepo(getApplication());

        WAPS wap = new WAPS();
        wap.setValidated(true);
        wap.setRadius(15.0);
        wap.setLongitude(longitude);
        wap.setLatitude(latitude);
        wap.setMAC(MAC);
        wap.setOrgID(OrgID);

        dbRepo.insert(wap);

        Toast.makeText(getApplicationContext(),"Option to validate later", Toast.LENGTH_LONG).show();
    }
    public void clicked_skip(View view) {
        Toast.makeText(getApplicationContext(),"Option to skip entry", Toast.LENGTH_LONG).show();
    }
}