package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by vajrayogini on 3/7/16.
 */
//annotation to tell spring this is a controller class
@Controller
public class HelloSpringController {
    User user = null;

    @RequestMapping(path = "/person", method = RequestMethod.GET) //annotation defines name of route and whether get/post et
    public String person(Model model, String name, String city, int age) { //method. Boxed integer to be optional value
        Person p = new Person(name, city, age); //inject into mustache
        model.addAttribute("person", p);
        return "person";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) { //has to match html
        session.setAttribute("userName", userName); //if want to store it
        return "redirect:/";
    }
}
