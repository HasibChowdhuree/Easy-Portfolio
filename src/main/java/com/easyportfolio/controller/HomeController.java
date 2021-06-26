package com.easyportfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String Home(Model model){
        model.addAttribute("title", "Easy Portfolio");
        return "home";
    }

    @RequestMapping("/signup")
    public String Register(Model model){
        model.addAttribute("title", "Sign up - Easy Portfolio");
        return "signup";
    }

    @RequestMapping("/signin")
    public String Login(Model model){
        model.addAttribute("title", "Sign in - Easy Portfolio");
        return "signin";
    }
    
    @GetMapping("/createcv")
    public String CreateCV(Model model){
        model.addAttribute("title", "Create CV - Easy Portfolio");
        return "createcv";
    }
//    @RequestMapping(path="/createcv", method=RequestMethod.POST)
//    public String CreateCV(final DetailInfo details, Model model){
//        model.addAttribute("title", "Create CV - Easy Portfolio");
//        return "createcv";
//    }
    
}