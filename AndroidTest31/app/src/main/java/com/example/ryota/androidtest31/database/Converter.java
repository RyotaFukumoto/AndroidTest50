package com.example.ryota.androidtest31.database;


import android.arch.persistence.room.TypeConverter;

import com.example.ryota.androidtest31.api.model.Image;

class Converter {
    @TypeConverter
    public static String toUrl(Image image){
        return image.getUrl();
    }

    @TypeConverter
    public static Image toImage(String url){
        Image image = new Image();
        image.setUrl(url);
        return image;
    }
}

