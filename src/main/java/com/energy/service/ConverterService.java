package com.energy.service;

import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

import javax.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;

import static com.energy.utils.StringUtils.*;

@Service
public class ConverterService {

    private  Map<String, String> monthsMapping;

    public String convertYear(String period) {
        return period;
    }

    public String convertQuarter(String period) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(period.charAt(0))
                .append(period.charAt(7))
                .append("-")
                .append(period.charAt(4))
                .append(period.charAt(5));

        return stringBuilder.toString();
    }

    public String convertSeason(String period) {
        if(StringUtils.isBlank(period) || period.length() != 11) {
            throw new IllegalArgumentException("Season period is not valid");
        }

        StringBuilder stringBuilder = new StringBuilder();

        String shortSeason = calculateShortSeason(period.substring(period.length() - 2));
        String shortYear = period.substring(6, 8);

        stringBuilder
                .append(shortSeason)
                .append("-")
                .append(shortYear);

        return stringBuilder.toString();
    }

    public String convertMonth(String period) {

        if(StringUtils.isBlank(period) || period.length() != 9) {
            throw new IllegalArgumentException("Month period is not valid.");
        }

        StringBuilder stringBuilder = new StringBuilder();
        String year = period.substring(2, 6);
        String shortMonth = period.substring(period.length() - 2, period.length());

        stringBuilder
                .append(monthsMapping.get(shortMonth))
                .append("-")
                .append(year);

        return stringBuilder.toString();
    }

    @PostConstruct
    private void initMonthsMapping() {
        this.monthsMapping = new HashMap<>();

        monthsMapping.put("01", "Jan");
        monthsMapping.put("02", "Feb");
        monthsMapping.put("03", "Mar");
        monthsMapping.put("04", "Apr");
        monthsMapping.put("05", "May");
        monthsMapping.put("06", "Jun");
        monthsMapping.put("07", "Jul");
        monthsMapping.put("08", "Aug");
        monthsMapping.put("09", "Sep");
        monthsMapping.put("10", "Oct");
        monthsMapping.put("11", "Nov");
        monthsMapping.put("12", "Dec");
    }

}
