package com.example.ryota.androidtest31.api.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity

public class Forecast {
    @PrimaryKey(autoGenerate = true)
    private long uid;
    private String dateLabel;
    private String telop;
    private String date;
    private Image image;

    public void setDateLabel(String dateLabel) {
        this.dateLabel = dateLabel;
    }

    public void setTelop(String telop) {
        this.telop = telop;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImage(Image image) {
        this.image = image;
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