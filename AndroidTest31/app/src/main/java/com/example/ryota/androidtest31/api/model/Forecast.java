/**
 * Copyright (C) 2016 Programming Java Android Development Project
 * Programming Java is
 * <p>
 * http://java-lang-programming.com/
 * <p>
 * Gson Generator version : 1.0.0
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.ryota.androidtest31.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * An Gson class for Weather
 */
public class Forecast {
    @SerializedName("dateLabel")
    private String dateLabel;
    @SerializedName("telop")
    private String telop;
    @SerializedName("date")
    private String date;
    //public Temperature temperature;
    @SerializedName("image")
    private Image image;

    public Forecast(String dateLabel, String telop, String date, Image image) {
        this.dateLabel = dateLabel;
        this.telop = telop;
        this.date = date;
        this.image = image;
    }

    public Forecast() {
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
}
