package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

// The view model allows us to get all the data we need to based on the database
public class ItemsViewModel extends AndroidViewModel {
    private AppDbRepo dbRepo;

    public ItemsViewModel(Application application){
        super(application);
        dbRepo = new AppDbRepo(application);
    }

    // Return the LiveData from the database
    public LiveData<List<Items>> getAllItems(int ListID) {
        return dbRepo.getItemsForList(ListID);
    }

    // Insert a new value from the database
    public void insert(Items item){
        dbRepo.insert(item);
    }
}
