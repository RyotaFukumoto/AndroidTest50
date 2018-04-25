package com.example.ryota.androidtest26;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class DateFormater {
    private final DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
    public Date getNow(){
        return new Date(System.currentTimeMillis());
    }


    public String getNowDate(){

        Date date = new Date(System.currentTimeMillis());
        return this.df.format(date);
    }

    public String getLimitDateFrom(String dateStr){
        Calendar calendar = Calendar.getInstance();


        Date date = new Date(dateStr);
        calendar.setTime(date);
        calendar.add(Calendar.DATE,7);
        Date limitDate = new Date(calendar.getTimeInMillis());
        return this.df.format(limitDate);
    }
}
