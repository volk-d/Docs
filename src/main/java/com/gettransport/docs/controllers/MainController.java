package com.gettransport.docs.controllers;

import com.gettransport.docs.DocsApplication;
import com.gettransport.docs.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping()
    public String greeting(Model model) {
        model.addAttribute("post", new Post());
        return "test";
    }
    @PostMapping("/test")
    public String agent(@RequestParam("shipper_name") String shipper_name){
        System.out.println(shipper_name);
        return "test";
    }
}