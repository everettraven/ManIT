package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.OrganizationPage;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.Organizations;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.R;

// This class is the view holder that extends the RecyclerView.ViewHolder class
// All the UI actions/binding occurs with this object.
public class OrgViewHolder extends RecyclerView.ViewHolder{
    private final TextView orgItemView;

    // This allows us to create the ViewHolder class and get a reference to the item that we want to dynamically change
    private OrgViewHolder(View itemView){
        super(itemView);
        orgItemView = itemView.findViewById(R.id.orgText);
    }

    // This is where all the magic happens. When the data binds we updated each component.
    public void bind(Orgs org){
        String text = org.getName();
        orgItemView.setText(text);
        orgItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OrganizationPage.class);
                intent.putExtra("Organization", org.getName());
                intent.putExtra("OrgID", org.getOrgID());
                v.getContext().startActivity(intent);
            }
        });
    }

    // We use this function in the ListAdapter to get the proper view holder
    static OrgViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orgrecyclerview_item, parent, false);
        return new OrgViewHolder(view);
    }

}