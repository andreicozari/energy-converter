package com.energy.service;

import com.energy.EnergyConverterApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EnergyConverterApplication.class)
public class ConverterServiceTest {

    @Mock
    private ConverterService converterService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void whenYearConverterIsCalled_thenResultIsTheSameValue() {
        String yearToTest = "2018";
        Mockito.when(converterService.convertYear(yearToTest)).thenReturn(yearToTest);
        String resultYear = converterService.convertYear(yearToTest);
        assertEquals(yearToTest, resultYear);
    }

    @Test
    public void whenQuarterConverterIsCalled_thenResultIsCorrect() {
        String quarterInputToTest = "Q-2018-2";
        String expectedResult = "Q2-18";
        Mockito.when(converterService.convertQuarter(quarterInputToTest)).thenReturn(expectedResult);
        String resultQuarter = converterService.convertQuarter(quarterInputToTest);
        assertEquals(quarterInputToTest, resultQuarter);
    }


    @Test
    public void whenSeasonConverterIsCalled_thenResultIsCorrect() {
        String seasonInputToTest = "SWS-2018-04";
        String expectedResult = "Sum-18";
        Mockito.when(converterService.convertSeason(seasonInputToTest)).thenReturn(expectedResult);
        String resultQuarter = converterService.convertSeason(seasonInputToTest);
        assertEquals(seasonInputToTest, resultQuarter);
    }

    @Test
    public void whenMonthConverterIsCalled_thenResultIsCorrect() {
        String monthInputToTest = "M-2018-02";
        String expectedResult = "Feb-2018";
        Mockito.when(converterService.convertMonth(monthInputToTest)).thenReturn(expectedResult);
        String resultQuarter = converterService.convertMonth(monthInputToTest);
        assertEquals(monthInputToTest, resultQuarter);
    }

}
