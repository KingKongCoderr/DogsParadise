package randomtechsolutions.com.dogsparadise.RoomDatabase.Entities;

/**
 * Created by nande on 10/18/2017.
 */


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class BreedsPojo {

    @PrimaryKey
    private int breedsid;
    
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    @ColumnInfo(name = "breed_names")
    private List<String> message;

    public int getBreedsid() {
        return breedsid;
    }

    public void setBreedsid(int breedsid) {
        this.breedsid = breedsid;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<String> getMessage() {
        return message;
    }
    
    public void setMessage(List<String> message) {
        this.message = message;
    }
    
}