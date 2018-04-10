package com.example.ryota.androidtest18;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class RowData {
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public Image getImage() {
        return this.image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    private Image image;
}
