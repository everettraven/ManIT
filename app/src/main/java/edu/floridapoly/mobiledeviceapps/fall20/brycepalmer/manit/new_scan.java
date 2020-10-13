package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class new_scan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_scan);
    }

    public void clicked_add_WAP(View view) {
        Toast.makeText(getApplicationContext(),"Adds WAP data to database", Toast.LENGTH_LONG).show();
    }
    public void clicked_validate(View view) {
        Toast.makeText(getApplicationContext(),"Option to validate later", Toast.LENGTH_LONG).show();
    }
    public void clicked_skip(View view) {
        Toast.makeText(getApplicationContext(),"Option to skip entry", Toast.LENGTH_LONG).show();
    }
}