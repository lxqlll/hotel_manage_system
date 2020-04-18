package com.example.hotelmanagesys.util;

import java.util.Calendar;

public class SystemTime {

    public static long nowTime(){
        Calendar now = Calendar.getInstance();
        String year  = ""+now.get(Calendar.YEAR);
        String month  = ""+(now.get(Calendar.MONTH) + 1);
        String day_of_month  = ""+now.get(Calendar.DAY_OF_MONTH);
        String hour_of_day  = ""+now.get(Calendar.HOUR_OF_DAY);
        String minute = ""+now.get(Calendar.MINUTE);
        String second = ""+now.get(Calendar.SECOND);
        if (month.length()==1){
            month="0"+month;
        }
        if (day_of_month.length()==1){
            day_of_month="0"+day_of_month;
        }
        if (hour_of_day.length()==1){
            hour_of_day="0"+hour_of_day;
        }
        if (hour_of_day.length()==1){
            hour_of_day="0"+hour_of_day;
        }
        String nowTime =year+month+day_of_month+hour_of_day+minute+second;

        return Long.parseLong(nowTime);
    }

}
