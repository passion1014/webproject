package com.worldchurch.webproject.test.controller;

import com.worldchurch.webproject.test.service.HelloWorldService;
import com.worldchurch.webproject.test.service.HelloWorldServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
}
