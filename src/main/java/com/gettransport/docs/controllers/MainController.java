package com.gettransport.docs.controllers;

import com.gettransport.docs.model.Signer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("post", new Signer());
        return "carriage_contract";
    }

    @GetMapping("/agency_contract")
    public String agency_contract(Model model) {
        model.addAttribute("post", new Signer());
        return "agency_contract";
    }

    @GetMapping("/license_agreement")
    public String license_agreement(Model model) {
        model.addAttribute("post", new Signer());
        return "license_agreement";
    }

    @GetMapping("/carriage_contract")
    public String carriage_contract(Model model) {
        model.addAttribute("post", new Signer());
        return "carriage_contract";
    }

    @PostMapping("/shipper")
    public String agent(@RequestParam("shipper_name") String shipper_name,
                        @RequestParam("shipper_signatory") String shipper_signatory,
                        @RequestParam("shipper_requisites") String shipper_requisites){
        System.out.println(shipper_name);
        System.out.println(shipper_signatory);
        System.out.println(shipper_requisites);
        return "agency_contract";
    }
    @PostMapping("/carrier")
    public String licensed( @RequestParam("carrier_name") String carrier_name,
                            @RequestParam("carrier_signatory") String carrier_signatory,
                            @RequestParam("carrier_requisites") String carrier_requisites){
        System.out.println(carrier_name);
        System.out.println(carrier_signatory);
        System.out.println(carrier_requisites);
        return "license_agreement";
    }
    @PostMapping("/carriage")
    public String carriage( @RequestParam("carrier_name") String carrier_name,
                            @RequestParam("carrier_signatory") String carrier_signatory,
                            @RequestParam("carrier_requisites") String carrier_requisites,
                            @RequestParam("shipper_name") String shipper_name,
                            @RequestParam("shipper_signatory") String shipper_signatory,
                            @RequestParam("shipper_requisites") String shipper_requisites){
        System.out.println(shipper_name);
        System.out.println(shipper_signatory);
        System.out.println(shipper_requisites);
        System.out.println(carrier_name);
        System.out.println(carrier_signatory);
        System.out.println(carrier_requisites);
        return "carriage_contract";
    }
}