package org.viators.practice_project9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.viators.practice_project9.model.Holiday;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {

    @GetMapping(value = "/holidays")
    public String displayHolidays(Model model) {
        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ", "Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ", "Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ", "Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Sep 5 ", "Labor Day", Holiday.Type.FEDERAL)
        );

        var types = Holiday.Type.values();
        for (var type : types) {
            model.addAttribute(type.toString(),
                    holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList()));
        }

        return "holidays.html";
    }
}
