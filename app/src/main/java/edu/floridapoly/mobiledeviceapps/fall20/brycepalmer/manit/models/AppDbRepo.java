package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.telecom.Call;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class AppDbRepo {
    private OrgsDao orgsDao;
    private ItemsDao itemsDao;
    private ListsDao listsDao;
    private WAPDao wapsDao;

    public AppDbRepo(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        orgsDao = db.orgsDao();
        listsDao = db.listsDao();
        itemsDao = db.itemsDao();
        wapsDao = db.wapsDao();
    }

    // Insert Functions
    public void insert(Orgs org){
        AppDatabase.databaseExecutor.execute(()->{
            orgsDao.insert(org);
        });
    }

    public void insert(Lists list){
        AppDatabase.databaseExecutor.execute(()->{
            listsDao.insert(list);
        });
    }

    public void insert(Items item){
        AppDatabase.databaseExecutor.execute(()->{
            itemsDao.insert(item);
        });
    }

    public void insert(WAPS wap){
        AppDatabase.databaseExecutor.execute(()->{
            wapsDao.insert(wap);
        });
    }

    // Delete functions

    public void delete(Orgs org){
        AppDatabase.databaseExecutor.execute(()->{
            orgsDao.delete(org);
        });
    }

    public void deleteAllOrgs(){
        AppDatabase.databaseExecutor.execute(()->{
            orgsDao.deleteAll();
        });
    }


    public void delete(Lists list){
        AppDatabase.databaseExecutor.execute(()->{
            listsDao.delete(list);
        });
    }

    public void delete(Items item){
        AppDatabase.databaseExecutor.execute(()->{
            itemsDao.delete(item);
        });
    }

    public void delete(WAPS wap){
        AppDatabase.databaseExecutor.execute(()->{
            wapsDao.delete(wap);
        });
    }

    // Get functions

    public LiveData<List<Orgs>> getAllOrgs(){
        return orgsDao.getAll();
    }

    public Orgs getOrg(int id) {return orgsDao.getById(id);}

    public LiveData<List<Lists>> getAllLists(){
        return listsDao.getAll();
    }

    public LiveData<List<Lists>> getListForOrg(int OrgID){return listsDao.getAllForOrg(OrgID);}

    public List<Items> getAllItems(){
        return itemsDao.getAll();
    }

    public LiveData<List<Items>> getItemsForList(int ListID) { return itemsDao.getAllFromList(ListID); }

    public List<WAPS> getAllWAPS(){
        return wapsDao.getAll();
    }

}
