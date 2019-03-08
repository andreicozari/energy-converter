package com.energy.service;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    public String convertYear(String year) {
        return year;
    }

    public String convertQuarter(String quarter) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(quarter.charAt(0))
                .append(quarter.charAt(7))
                .append("-")
                .append(quarter.charAt(4))
                .append(quarter.charAt(5));

        return stringBuilder.toString();
    }

    public String convertSeason(String season) {
        return season;
    }

    public String convertMonth(String month) {
        return month;
    }

}
