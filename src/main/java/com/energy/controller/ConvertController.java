package com.energy.controller;

import com.energy.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class ConvertController {

    private final ConverterService converterService;

    @Autowired
    public ConvertController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @GetMapping("/year/{year}")
    public String convertYear(@PathVariable String year) {
        return converterService.convertYear(year);
    }

    @GetMapping("/quarter/{quarter}")
    public String convertQuarter(@PathVariable String quarter) {
        return converterService.convertQuarter(quarter);
    }

    @GetMapping("/season/{season}")
    public String convertSeason(@PathVariable String season) {
        return converterService.convertSeason(season);
    }

    @GetMapping("/month/{month}")
    public String convertMonth(@PathVariable String month) {
        return converterService.convertMonth(month);
    }

}
