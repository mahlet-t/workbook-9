package com.pluralsight.NorthwindTradersAPI.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @GetMapping(path = "/")
    public String hello(
            @RequestParam(defaultValue = "World") String country
    ) {
        return "Hello " + country + "!";

    }
}