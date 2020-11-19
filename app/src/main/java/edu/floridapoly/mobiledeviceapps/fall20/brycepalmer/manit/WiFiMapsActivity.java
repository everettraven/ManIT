package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class WiFiMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    protected Marker createMarker(double latitude, double longitude, String title, String snippet, int iconResID) {
        return googleMap.addMarker(new MarkerOptions()
        .position(new LatLng(name.latitude, name.longitude))
                .anchor(0.5f, 0.5f)
                .title(name.name)
                .snippet("WAP Name: " + name.wapname +"Net Name: " + name. BSSID + "IP: "
                        + name.IP + "MAC Adsdess: "+ name.MAC + "Signal Strength"
                        + name.sigstrength));
    }
    int loopcnt =0;
    while(loopcnt == 0)
    {
        if(listlocation from database  !=null){
            createMarker();
            //move in the saved list ++;
        }else

        {
            Toast.makeText(getApplicationContext(), "No Saved Waps/ End of List Loaded", Toast.LENGTH_LONG).show();
            loopcnt = 1;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */



}