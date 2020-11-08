package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Lists {
    @PrimaryKey(autoGenerate = true)
    private int ListID;

    private String Name;

    @ForeignKey(
            entity = Orgs.class,
            parentColumns = "OrgID",
            childColumns = "OrgID",
            onDelete = ForeignKey.CASCADE)
    private int OrgID;

    public void setListID(int listID) {
        this.ListID = listID;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public void setOrgID(int orgID)
    {
        this.OrgID = orgID;
    }

    public int getListID(){
        return this.ListID;
    }

    public int getOrgID(){
        return this.OrgID;
    }

    public String getName(){
        return this.Name;
    }
}
