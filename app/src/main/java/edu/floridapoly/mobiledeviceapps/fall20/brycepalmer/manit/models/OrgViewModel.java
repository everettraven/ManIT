package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

// The view model allows us to get all the data we need to based on the database
public class OrgViewModel extends AndroidViewModel {
    private AppDbRepo dbRepo;
    private LiveData<List<Orgs>> allOrgs;

    public OrgViewModel(Application application){
        super(application);
        dbRepo = new AppDbRepo(application);
        allOrgs = dbRepo.getAllOrgs();
    }

    // Return the LiveData from the database
    public LiveData<List<Orgs>> getAllOrgs() {
        return allOrgs;
    }

    // Insert a new value from the database
    public void insert(Orgs org){
        dbRepo.insert(org);
    }
}
