package com.example.ryota.androidtest31.api.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

<<<<<<< HEAD
import java.util.List;

/**
 * An Gson class for Weather
 */
public class Forecast {
    @SerializedName("dateLabel")
    private String dateLabel;
    @SerializedName("telop")
    private String telop;
    @SerializedName("date")
<<<<<<< HEAD
    private String date;
=======
    public String date;

    public Temperature temperature;
>>>>>>> AndroidTest35
    //public Temperature temperature;
    @SerializedName("image")
    private Image image;

    public Forecast(String dateLabel, String telop, String date, Image image,Temperature temperature) {
=======
@Entity

public class Forecast {
    @PrimaryKey(autoGenerate = true)
    private long uid;
    private String dateLabel;
    private String telop;
    private String date;
    private Image image;

    public void setDateLabel(String dateLabel) {
>>>>>>> AndroidTest33
        this.dateLabel = dateLabel;
    }

    public void setTelop(String telop) {
        this.telop = telop;
    }

    public void setDate(String date) {
        this.date = date;
<<<<<<< HEAD
        this.image = image;
        this.temperature = temperature;
=======
>>>>>>> AndroidTest33
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Temperature getTemperatures() {
        return this.temperature;
    }

    public String getDateLabel() {
        return this.dateLabel;
    }

    public String getTelop() {
        return this.telop;
    }

    public String getDate() {
        return this.date;
    }

    public Image getImage() {
        return this.image;
    }

    public long getUid() {
        return this.uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
}