package com.github.rmnasri;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

@Controller
public class WelcomeController {

    @Value("${application.message:Hello World}")
    private static String GREETINGS = "Hello ";


    @RequestMapping(value="/helloWorld")
    public String welcome(Map<String, Object> model) {
        model.put("message", GREETINGS+"World!");
        return "welcome";
    }

}