package com.gettransport.docs.controllers;

import com.gettransport.docs.file.CreatingFile;
import com.gettransport.docs.model.Carriage;
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
                            @RequestParam("shipper_requisites") String shipper_requisites,
                            @RequestParam("loading_place") String loading_place,
                            @RequestParam("unloading_place") String unloading_place,
                            @RequestParam("cargo") String cargo,
                            @RequestParam("pick_up_date") String pick_up_date,
                            @RequestParam("pick_down_date") String pick_down_date,
                            @RequestParam("price") String price,
                            @RequestParam("tax") String tax,
                            @RequestParam("number") String number){

        Carriage carriage = new Carriage(carrier_name,
                                         carrier_signatory,
                                         carrier_requisites,
                                         shipper_name,
                                         shipper_signatory,
                                         shipper_requisites,
                                         loading_place,
                                         unloading_place,
                                         cargo,
                                         pick_up_date,
                                         pick_down_date,
                                         price,
                                         tax,
                                         number);

      //  CreatingFile.creating(cargo);
        System.out.println(carrier_name.toString());

       // System.out.println(carriage);


        return "carriage_contract";
    }
}