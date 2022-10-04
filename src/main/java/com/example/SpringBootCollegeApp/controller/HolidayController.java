package com.example.SpringBootCollegeApp.controller;

import com.example.SpringBootCollegeApp.model.Holiday;
import com.example.SpringBootCollegeApp.repository.HolidayRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class HolidayController {
    @Autowired
    private HolidayRepository holidayRepository;

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display,
                                  Model model) {

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

        List<Holiday> holidays = IterableUtils.toList(holidayRepository.findAll());



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
