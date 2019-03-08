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

}
