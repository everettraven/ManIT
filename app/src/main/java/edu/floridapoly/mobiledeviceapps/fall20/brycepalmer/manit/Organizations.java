package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Organizations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Currently we are going to just make it so that every organization goes to the same view
    public void org_clicked(View view) {
        Button button = (Button) findViewById(view.getId());
        Intent intent = new Intent(Organizations.this, OrganizationPage.class);
        intent.putExtra("Organization", button.getText().toString());
        startActivity(intent);
    }

    public void clicked_add(View view) {
        Toast.makeText(this, "Add Action was clicked. This would add a new organization", Toast.LENGTH_LONG).show();
    }

    public void clicked_edit(View view) {
        Toast.makeText(this, "Edit Action was clicked. This would allow editing of an organization", Toast.LENGTH_LONG).show();
    }
}