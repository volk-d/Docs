package com.gettransport.docs.controllers;

import com.gettransport.docs.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("title", "Документы");
        return "home";
    }
    @PostMapping("/")
    public String agent(@RequestParam String carrier_name, @RequestParam String carrier_signatory, @RequestParam String carrier_requisites, Model model){
        Post post = new Post(carrier_name, carrier_signatory, carrier_requisites);
        return "";
    }
}