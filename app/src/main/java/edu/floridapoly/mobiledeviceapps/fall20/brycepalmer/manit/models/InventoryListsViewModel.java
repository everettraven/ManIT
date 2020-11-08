package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

// The view model allows us to get all the data we need to based on the database
public class InventoryListsViewModel extends AndroidViewModel {
    private AppDbRepo dbRepo;
    private LiveData<List<Lists>> allLists;

    public InventoryListsViewModel(Application application){
        super(application);
        dbRepo = new AppDbRepo(application);
    }

    // Return the LiveData from the database
    public LiveData<List<Lists>> getAllLists(int OrgID) {
        return dbRepo.getListForOrg(OrgID);
    }

    // Insert a new value from the database
    public void insert(Lists list){
        dbRepo.insert(list);
    }
}
