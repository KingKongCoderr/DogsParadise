package randomtechsolutions.com.dogsparadise.model;

/**
 * Created by nande on 10/18/2017.
 */

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Breeds  {
    
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private List<String> message;
    
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