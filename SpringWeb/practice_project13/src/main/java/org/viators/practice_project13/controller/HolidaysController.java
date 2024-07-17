package org.viators.practice_project13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.viators.practice_project13.model.Holiday;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {

    /*
    @GetMapping(value = "/holidays")
    public String displayHolidays(@RequestParam(required = false) boolean festival,
                                  @RequestParam(required = false) boolean federal,
                                  Model model) {
        model.addAttribute("festival", festival);
        model.addAttribute("federal", federal);

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
    */

    @GetMapping(value = "/holidays/{display}")
    public String displayHolidays(@PathVariable() String display,
                                  Model model) {
        if (display != null && display.equals("all")){
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        } else if (display != null && display.equals("festival")) {
            model.addAttribute("festival", true);
        } else if (display != null && display.equals("federal")) {
            model.addAttribute("federal",true);
        }

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
