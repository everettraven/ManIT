package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Items {
    @PrimaryKey(autoGenerate = true)
    private int ItemID;

    private String SerialNumber;

    private String Name;

    private String Description;

    @ForeignKey(
            entity = Lists.class,
            parentColumns = "ListID",
            childColumns = "ListID",
            onDelete = ForeignKey.CASCADE)
    private int ListID;

    public void setItemID(int ItemID){
        this.ItemID = ItemID;
    }

    public void setSerialNumber(String SerialNumber){
        this.SerialNumber = SerialNumber;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public void setDescription(String Description){
        this.Description = Description;
    }

    public void setListID(int listID) {
        this.ListID = listID;
    }

    public int getItemID(){
        return this.ItemID;
    }

    public String getSerialNumber(){
        return this.SerialNumber;
    }

    public String getName(){
        return this.Name;
    }

    public String getDescription(){
        return this.Description;
    }

    public int getListID(){
        return this.ListID;
    }

}
