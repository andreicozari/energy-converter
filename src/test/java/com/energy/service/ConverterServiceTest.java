package com.energy.service;

import com.energy.EnergyConverterApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EnergyConverterApplication.class)
public class ConverterServiceTest {

    @Autowired
    private ConverterService converterService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testConvertYear() {
        String yearToTest = "2018";
        String resultYear = converterService.convertYear(yearToTest);
        assertEquals(yearToTest, resultYear);
    }

    @Test
    public void testConvertQuarter() {
        String quarterInputToTest = "Q-2018-2";
        String expectedResult = "Q2-18";
        assertThat(converterService.convertQuarter(quarterInputToTest)).isEqualTo(expectedResult);
    }


    @Test
    public void testConvertSeason() {
        String seasonInputToTest = "SWS-2018-04";
        String expectedResult = "Spr-18";
        String resultQuarter = converterService.convertSeason(seasonInputToTest);
        assertEquals(expectedResult, resultQuarter);
    }

    @Test
    public void testMonthConverter() {
        String monthInputToTest = "M-2018-02";
        String expectedResult = "Feb-2018";
        String resultQuarter = converterService.convertMonth(monthInputToTest);
        assertEquals(expectedResult, resultQuarter);
    }
}
