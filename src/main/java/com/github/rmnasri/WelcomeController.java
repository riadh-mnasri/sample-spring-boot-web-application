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
        model.put("time", new Date());
        model.put("message", GREETINGS+"World!");
        return "welcome";
    }

    @RequestMapping(value="/hello")
    public String helloSomeone(Map<String, Object> model, @RequestParam("who") String persons) {
        model.put("time", new Date());
        StringBuilder completeMessage = new StringBuilder(GREETINGS);
        completeMessage.append(persons);
        model.put("message", completeMessage.toString());
        return "welcome";
    }

    @RequestMapping("/greetings/{someone}")
    public ModelAndView hiSomeone(@PathVariable("someone") String username) {
        ModelAndView mav = new ModelAndView("welcome");
        mav.addObject("time", new Date());
        mav.addObject("message", "Hello :: " + username);
        return mav;
    }

/*    @RequestMapping("/greetings/{someone}")
    public String hiSomeone(Model model, @PathVariable("someone") String username) {
        model.addAttribute("time", new Date());
        model.addAttribute("message", "Hello :: " + username);
        return "welcome";
    }*/


/*    @RequestMapping(value="/greetings/{someone}")
    public String hiSomeone(Map<String, Object> model, @PathVariable("someone") String username) {
        model.put("time", new Date());
        StringBuilder completeMessage = new StringBuilder(GREETINGS);
        completeMessage.append(username);
        model.put("message", completeMessage.toString());
        return "welcome";
    }*/

}