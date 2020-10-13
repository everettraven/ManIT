package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OrganizationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_page);

        TextView title = (TextView) findViewById(R.id.org_title);
        Intent callerIntent = getIntent();
        title.setText(callerIntent.getStringExtra("Organization"));
    }

    public void clicked_wifi(View view) {
        Intent startIntent = new Intent(OrganizationPage.this, wifi_scan.class);
        startActivity(startIntent);
    }

    public void clicked_inventory(View view)
    {
        Intent intent = new Intent(OrganizationPage.this, PhysicalInventory_Lists.class);
        startActivity(intent);
    }
}