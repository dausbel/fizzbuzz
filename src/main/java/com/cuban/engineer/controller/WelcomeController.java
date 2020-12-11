package com.cuban.engineer.controller;

import com.cuban.engineer.service.FizzBuzzService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
    private final FizzBuzzService fizzBuzzService;

    public WelcomeController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }


    /**
     * @param start
     * @param end
     * @param model
     * @return
     */
    @GetMapping("/")
    public String main(
            @RequestParam(name = "start", required = false, defaultValue = "1") Integer start,
            @RequestParam(name = "end", required = false, defaultValue = "100") Integer end,
            Model model) {
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        model.addAttribute("tasks", fizzBuzzService.fizzBuzz(start, end));
        return "welcome"; //view
    }

}