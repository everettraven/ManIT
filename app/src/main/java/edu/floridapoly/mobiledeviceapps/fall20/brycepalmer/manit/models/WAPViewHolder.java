package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.ItemDetails;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.OrganizationPage;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.Organizations;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.PhysicalInventory_List_Details;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.R;

// This class is the view holder that extends the RecyclerView.ViewHolder class
// All the UI actions/binding occurs with this object.
public class WAPViewHolder extends RecyclerView.ViewHolder{
    private final TextView itemsItemView;

    // This allows us to create the ViewHolder class and get a reference to the item that we want to dynamically change
    private WAPViewHolder(View itemView){
        super(itemView);
        itemsItemView = itemView.findViewById(R.id.itemText);
    }

    // This is where all the magic happens. When the data binds we updated each component.
    public void bind(WAPS item){
        String text = item.getMAC();
        itemsItemView.setText(text);
        itemsItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "WAP was clicked, this would perform our animation to show more details about the item.", Toast.LENGTH_LONG).show();
            }
        });
    }

    // We use this function in the ListAdapter to get the proper view holder
    static WAPViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wapsrecyclerview_item, parent, false);
        return new WAPViewHolder(view);
    }

}