package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Orgs {
    @PrimaryKey(autoGenerate = true)
    private int OrgID;

    private String Name;

    public Orgs(String Name){
        this.Name = Name;
    }

    public void setOrgID(int OrgID){
        this.OrgID = OrgID;
    }


    public String getName() {
        return this.Name;
    }

    public int getOrgID() {
        return this.OrgID;
    }
}
