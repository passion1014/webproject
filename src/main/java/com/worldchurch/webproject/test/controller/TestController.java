package com.worldchurch.webproject.test.controller;

import com.worldchurch.webproject.test.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TestController {
    @Autowired
    HelloWorldService helloWorldService;

    @GetMapping("/test/{name}")
    public String hello(@PathVariable("name") String name, Model model) {
        // return helloWorldService.getGreeting(name);
        model.addAttribute("data", name);

        return "test/hello";
    }

    @GetMapping("/redirect/test")
    public String redirectTest (RedirectAttributes attributes) {

        attributes.addFlashAttribute("flashAttr", "이성욱");
        return "redirect:/test/hello";
    }

    @GetMapping("/test/{name1}/{name2}")
    public String hello(@PathVariable("name1") String name1, @PathVariable("name2") String name2, Model model) {
        // return helloWorldService.getGreeting(name);
        model.addAttribute("data", name1);
        model.addAttribute("data1", name2);

        return "test/hello";
    }
}
