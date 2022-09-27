package com.example.SpringBootCollegeApp.controller;

import com.example.SpringBootCollegeApp.model.Holiday;
import com.example.SpringBootCollegeApp.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    @Autowired
    HolidayRepository holidayRepository;

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display,
                                  Model model,
                                  Authentication authentication) {

        if (display != null) {

            if (display.equals("all")) {
                model.addAttribute("federal", true);
                model.addAttribute("festival", true);
            } else if (display.equals("federal")) {
                model.addAttribute("federal", true);

            } else if (display.equals("festival")) {
                model.addAttribute("festival", true);
            }


        }


//        List<Holiday> holidays = Arrays.asList(
//                new Holiday(" Aug 11 ","Tu B'Av", Holiday.Type.FESTIVAL),
//                new Holiday(" Dec 18 ","Hanukkah", Holiday.Type.FESTIVAL),
//                new Holiday(" May 4 ","Lag BaOmer", Holiday.Type.FESTIVAL),
//                new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL),
//                new Holiday(" Oct 9 ","Sukkot", Holiday.Type.FEDERAL),
//                new Holiday(" Apr 9 ","Easter", Holiday.Type.FEDERAL),
//                new Holiday(" Mar 6 ","Purim", Holiday.Type.FEDERAL),
//                new Holiday(" Apr 5 ","Passover", Holiday.Type.FEDERAL)
//        );

        List<Holiday> holidays = holidayRepository.selectAllHoliday();





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
