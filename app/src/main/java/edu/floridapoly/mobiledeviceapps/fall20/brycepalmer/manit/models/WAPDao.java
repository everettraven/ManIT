package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WAPDao {
    @Insert
    void insertAll(WAPS... waps);

    @Insert
    void insert(WAPS wap);

    @Delete
    void delete(WAPS wap);

    @Query("SELECT * FROM WAPS")
    List<WAPS> getAll();

    //Can add more queries as needed

}
