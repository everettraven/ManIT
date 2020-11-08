package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ListsDao {
    @Insert
    void insertAll(Lists... lists);

    @Delete
    void delete(Lists list);

    @Query("SELECT * FROM lists")
    LiveData<List<Lists>> getAll();

    @Query("SELECT * FROM lists WHERE OrgID = (:OrgID)")
    LiveData<List<Lists>> getAllForOrg(int OrgID);

    @Insert
    void insert(Lists list);

    //We can add more queries as needed
}
