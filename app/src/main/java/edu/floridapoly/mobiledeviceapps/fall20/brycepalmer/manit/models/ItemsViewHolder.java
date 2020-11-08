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
public class ItemsViewHolder extends RecyclerView.ViewHolder{
    private final TextView itemsItemView;

    // This allows us to create the ViewHolder class and get a reference to the item that we want to dynamically change
    private ItemsViewHolder(View itemView){
        super(itemView);
        itemsItemView = itemView.findViewById(R.id.itemText);
    }

    // This is where all the magic happens. When the data binds we updated each component.
    public void bind(Items item){
        String text = item.getName();
        itemsItemView.setText(text);
        itemsItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Item was clicked, this would perform our animation to show more details about the item.", Toast.LENGTH_LONG).show();
            }
        });
    }

    // We use this function in the ListAdapter to get the proper view holder
    static ItemsViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsrecyclerview_item, parent, false);
        return new ItemsViewHolder(view);
    }

}