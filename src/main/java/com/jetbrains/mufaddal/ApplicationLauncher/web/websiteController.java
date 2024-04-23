package com.jetbrains.mufaddal.ApplicationLauncher.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @RestController: for every public method’s result will (more or less) directly be written to the HTTP response body, without going through an HTML templating library.
 * @Controller: want to serve HTML instead of JSON or XML.
 * */

@Controller
public class websiteController {
    @GetMapping("/")
    public String homepage() {
        return "index.html";
    }
}
