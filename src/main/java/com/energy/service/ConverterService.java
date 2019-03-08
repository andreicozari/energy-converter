package com.energy.service;

import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

import static com.energy.utils.StringUtils.*;

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
        if(StringUtils.isBlank(season) || season.length() != 11) {
            throw new IllegalArgumentException("Season must not be empty");
        }

        StringBuilder stringBuilder = new StringBuilder();

        String shortSeason = calculateShortSeason(season.substring(season.length() - 2));
        String shortYear = season.substring(6, 8);

        stringBuilder
                .append(shortSeason)
                .append("-")
                .append(shortYear);

        return stringBuilder.toString();
    }

    public String convertMonth(String month) {
        return month;
    }



}
