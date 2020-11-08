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
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.PhysicalInventory_List_Details;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.R;

// This class is the view holder that extends the RecyclerView.ViewHolder class
// All the UI actions/binding occurs with this object.
public class InventoryListsViewHolder extends RecyclerView.ViewHolder{
    private final TextView listsItemView;

    // This allows us to create the ViewHolder class and get a reference to the item that we want to dynamically change
    private InventoryListsViewHolder(View itemView){
        super(itemView);
        listsItemView = itemView.findViewById(R.id.listText);
    }

    // This is where all the magic happens. When the data binds we updated each component.
    public void bind(Lists list){
        String text = list.getName();
        listsItemView.setText(text);
        listsItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PhysicalInventory_List_Details.class);
                intent.putExtra("List", list.getName());
                intent.putExtra("ListID", list.getListID());
                v.getContext().startActivity(intent);
            }
        });
    }

    // We use this function in the ListAdapter to get the proper view holder
    static InventoryListsViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listsrecyclerview_item, parent, false);
        return new InventoryListsViewHolder(view);
    }

}