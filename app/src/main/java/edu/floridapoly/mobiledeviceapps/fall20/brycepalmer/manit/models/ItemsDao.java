package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemsDao {
    @Insert
    void insertAll(Items... items);

    @Insert
    void insert(Items item);

    @Delete
    void delete(Items item);

    @Query("SELECT * FROM items")
    List<Items> getAll();

    @Query("SELECT * FROM items WHERE ListID = (:ListID)")
    LiveData<List<Items>> getAllFromList(int ListID);
}

