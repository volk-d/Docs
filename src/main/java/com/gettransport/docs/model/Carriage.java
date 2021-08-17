package com.gettransport.docs.model;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

public class Carriage implements Data {

    private String carrier_name;
    private String carrier_signatory;
    private String carrier_requisites;
    private String shipper_name;
    private String shipper_signatory;
    private String shipper_requisites;
    private String loading_place;
    private String unloading_place;
    private String cargo;
    private String pick_up_date;
    private String pick_down_date;
    private String price;
    private String tax;
    private String number;




    public Carriage(String carrier_name,
                    String carrier_signatory,
                    String carrier_requisites,
                    String shipper_name,
                    String shipper_signatory,
                    String shipper_requisites,
                    String loading_place,
                    String unloading_place,
                    String cargo,
                    String pick_up_date,
                    String pick_down_date,
                    String price,
                    String tax,
                    String number) {
        this.carrier_name = carrier_name;
        this.carrier_signatory = carrier_signatory;
        this.carrier_requisites = carrier_requisites;
        this.shipper_name = shipper_name;
        this.shipper_signatory = shipper_signatory;
        this.shipper_requisites = shipper_requisites;
        this.loading_place = loading_place;
        this.unloading_place = unloading_place;
        this.cargo = cargo;
        this.pick_up_date = pick_up_date;
        this.pick_down_date = pick_down_date;
        this.price = price;
        this.tax = tax;
        this.number = number;
    }

    @Override
    public Map<String, String> getMap() {
        Map<String,String> variable = new HashMap<>();

        variable.put("carrier_name", carrier_name);
        variable.put("carrier_signatory", carrier_signatory);
        variable.put("carrier_requisites", carrier_requisites);
        variable.put("shipper_name", shipper_name);
        variable.put("shipper_signatory", shipper_signatory);
        variable.put("shipper_requisites", shipper_requisites);
        variable.put("loading_place", loading_place);
        variable.put("unloading_place", unloading_place);
        variable.put("cargo", cargo);
        variable.put("pick_up_date", pick_up_date);
        variable.put("pick_down_date", pick_down_date);
        variable.put("price", price);
        variable.put("tax", tax);
        variable.put("number", number);

        return variable;

    }
    @Override
    public boolean isTax() {
        if(tax.isEmpty()) return false;
        else return true;
    }
}
