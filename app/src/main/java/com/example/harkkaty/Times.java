package com.example.harkkaty;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Times {

    private int i;

    //sets current date into a variable and makes 2 different format patterns for string of date
    private Date date = Calendar.getInstance().getTime();
    private Calendar cal = Calendar.getInstance();
    @SuppressLint("SimpleDateFormat")
    private SimpleDateFormat formatter = new SimpleDateFormat("EEE dd.MM");
    @SuppressLint("SimpleDateFormat")
    private SimpleDateFormat formatter2 = new SimpleDateFormat("EEE");
    private String formatted_date = formatter.format(date);

    String setDate(int i)
    {
        //sets date by adding or substracting i amount (depending on if its negative or positive) of days
        // formats the date for the "foodmenu" and returns the value
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, i);
        date = cal.getTime();
        formatted_date = formatter.format(date);
        return formatted_date;
    }

    String getFormatted_date()
    {
        return formatted_date;
    }

    int dateCheck()
    {
        //formats the date and checks which day is it and returns i for setting the right food menu of the day
        String formatted_date2 = formatter2.format(date);
        switch (formatted_date2) {
            case "Mon":
                i = 0;
                break;
            case "Tue":
                i = 1;
                break;
            case "Wed":
                i = 2;
                break;
            case "Thu":
                i = 3;
                break;
            case "Fri":
                i = 4;
                break;
            case "Sat":
                i = 5;
                break;
            case "Sun":
                i = 6;
                break;
        }
        return i;
    }
}
