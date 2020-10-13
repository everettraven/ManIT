package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ValidateWAP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate_w_a_p);
    }

    public void wap_clicked(View view) {
        Toast.makeText(this, "WAP was clicked. This would activate the animation to display more details about the WAP and allow for validation", Toast.LENGTH_LONG).show();
    }
}