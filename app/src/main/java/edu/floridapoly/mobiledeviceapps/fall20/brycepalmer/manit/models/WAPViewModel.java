package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

// The view model allows us to get all the data we need to based on the database
public class WAPViewModel extends AndroidViewModel {
    private AppDbRepo dbRepo;

    public WAPViewModel(Application application){
        super(application);
        dbRepo = new AppDbRepo(application);
    }

    // Return the LiveData from the database
    public LiveData<List<WAPS>> getAllWAPS(int OrgID) {
        return dbRepo.getWAPSForOrg(OrgID);
    }

    // Insert a new value from the database
    public void insert(WAPS wap){
        dbRepo.insert(wap);
    }
}
