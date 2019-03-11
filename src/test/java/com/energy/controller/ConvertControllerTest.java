package com.energy.controller;

import com.energy.service.ConverterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@WebMvcTest(ConvertController.class)
public class ConvertControllerTest  {

    @Autowired
    private MockMvc mockMvc;

    /*
    @Autowired
    private ObjectMapper objectMapper; */

    @MockBean
    private ConverterService converterService;

    @Test
    public void testConvertQuarter() throws Exception {

        String inputQuarter = "Q-2018-2";
        String expectedResult = "Q2-18";

        Mockito.when(converterService.convertQuarter(ArgumentMatchers.anyString())).thenReturn(expectedResult);

        MvcResult mvcResult = mockMvc
                .perform(get("/convert/quarter/" + inputQuarter))
                .andDo(print())
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expectedResult)))
                .andReturn();

    }

}
