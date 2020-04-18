package com.example.hotelmanagesys.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HiddenMsg {

    public static String infoHidden(String str){
        String regex = "(\\w{6})(\\w+)(\\w{3})";
        String var = str.replaceAll(regex, "$1****$3");
        return var;
    }


}
