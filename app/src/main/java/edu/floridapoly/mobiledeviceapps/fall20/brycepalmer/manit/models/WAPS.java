package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class WAPS {
    @PrimaryKey(autoGenerate = true)
    private int wapID;

    private String MAC;

    private double latitude;
    private double longitude;
    private double radius;

    private boolean validated;

    @ForeignKey(
            entity = Orgs.class,
            parentColumns = "OrgID",
            childColumns = "OrgID",
            onDelete = ForeignKey.CASCADE)
    private int OrgID;

    public void setWapID(int wapID) {
        this.wapID = wapID;
    }

    public void setOrgID(int orgID) {
        this.OrgID = orgID;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public int getOrgID() {
        return this.OrgID;
    }

    public int getWapID() {
        return this.wapID;
    }

    public boolean isValidated() {
        return validated;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRadius() {
        return radius;
    }

    public String getMAC() {
        return MAC;
    }
}
