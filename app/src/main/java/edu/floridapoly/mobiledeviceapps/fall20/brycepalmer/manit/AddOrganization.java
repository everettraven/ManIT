package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddOrganization extends AppCompatActivity {
    private EditText orgName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_organization);
    }

    public void create_org(View view){
        orgName = (EditText) findViewById(R.id.orgName);
        Intent intent = new Intent();
        intent.putExtra(Organizations.ORG_CREATION_KEY, orgName.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancel_org(View view){
        setResult(RESULT_CANCELED);
        finish();
    }

}