package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OrgsDao {
    @Insert
    void insertAll(Orgs... orgs);

    @Insert
    void insert(Orgs org);

    @Delete
    void delete(Orgs org);

    @Query("DELETE FROM orgs")
    void deleteAll();

    @Query("SELECT * FROM orgs")
    LiveData<List<Orgs>> getAll();

    @Query("SELECT * FROM orgs WHERE OrgID IN (:orgIds)")
    List<Orgs> getAllByIds(int[] orgIds);

    @Query("SELECT * FROM orgs WHERE OrgID = (:id)")
    Orgs getById(int id);

    // Can add more queries as needed
}
