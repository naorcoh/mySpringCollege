package com.example.SpringBootCollegeApp.controller;

import com.example.SpringBootCollegeApp.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    @GetMapping("/holidays")
    public String displayHolidays(
                                  @RequestParam(required = false) boolean festival,
                                  @RequestParam(required = false) boolean federal,
                                  Model model) {

        model.addAttribute("festival", festival);
        model.addAttribute("federal", federal);

        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Aug 11 ","Tu B'Av", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 18 ","Hanukkah", Holiday.Type.FESTIVAL),
                new Holiday(" May 4 ","Lag BaOmer", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 9 ","Sukkot", Holiday.Type.FEDERAL),
                new Holiday(" Apr 9 ","Easter", Holiday.Type.FEDERAL),
                new Holiday(" Mar 6 ","Purim", Holiday.Type.FEDERAL),
                new Holiday(" Apr 5 ","Passover", Holiday.Type.FEDERAL)
        );

        for (Holiday.Type type: Holiday.Type.values()) {

            model.addAttribute(
                    type.toString(),
                    holidays.stream()
                            .filter(holiday -> holiday.getType().equals(type))
                            .collect(Collectors.toList())

            );


        }

        return "holidays.html";

    }


}
