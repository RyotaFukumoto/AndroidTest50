package com.example.ryota.androidtest43;

public class RowData {private final String musicName;
    private final int id;

    RowData(String musicName, int id) {
        this.musicName = musicName;
        this.id = id;
    }

    public String getMusicName() {
        return this.musicName;
    }

    public int getId() {
        return this.id;
    }

}
