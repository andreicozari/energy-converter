package com.energy.utils;

public class StringUtils {

    public static String trimTheFirstZero(String val) {
        if (val.charAt(1) == '0') {
            return String.valueOf(val.charAt(1));
        }

        return val;
    }

    public static String calculateShortSeason(String season) {
        int month = Integer.valueOf(trimTheFirstZero(season));

        if (month < 0 || month > 12) {
            throw new IllegalArgumentException("The month from season is not in range.");
        }

        if (month == 12 ||  month <= 2) {
            return "Win";
        }

        if (month >= 3 || month <= 5) {
            return "Spr";
        }

        if (month >= 6 || month <= 8) {
            return "Sum";
        }

        return "Aut";
    }

}
