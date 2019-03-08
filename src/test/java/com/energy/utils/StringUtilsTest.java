package com.energy.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class StringUtilsTest {

    @Test
    public void testCalculateShortSeasonForWinterInputs() {
        List<String> seasonsInputToTest = Arrays.asList("12", "01", "02");
        String expectedResult = "Win";

        seasonsInputToTest.forEach((seasonInputToTest) -> {
            String resultQuarter = StringUtils.calculateShortSeason(seasonInputToTest);
            assertEquals(expectedResult, resultQuarter);
        });
    }
}
