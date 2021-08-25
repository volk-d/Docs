package com.gettransport.docs.model;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private boolean tax;
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
                    boolean tax,
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

    public Carriage() {
    }

    @Override
    public Map<String, String> getMap() {
        Map<String,String> variable = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

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
      //  variable.put("tax", tax);
        variable.put("number", number);
        variable.put("tdata", dateFormat.format(date));

        return variable;

    }
    @Override
    public boolean isTax() {
//        if(tax.isEmpty()) return false;
         return true;
    }


    @Override
    public String toString() {
        return "Carriage{" +
                "carrier_name='" + carrier_name + '\'' +
                ", carrier_signatory='" + carrier_signatory + '\'' +
                ", carrier_requisites='" + carrier_requisites + '\'' +
                ", shipper_name='" + shipper_name + '\'' +
                ", shipper_signatory='" + shipper_signatory + '\'' +
                ", shipper_requisites='" + shipper_requisites + '\'' +
                ", loading_place='" + loading_place + '\'' +
                ", unloading_place='" + unloading_place + '\'' +
                ", cargo='" + cargo + '\'' +
                ", pick_up_date='" + pick_up_date + '\'' +
                ", pick_down_date='" + pick_down_date + '\'' +
                ", price='" + price + '\'' +
                ", tax='" + tax + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public String getCarrier_name() {
        return carrier_name;
    }

    public String getCarrier_signatory() {
        return carrier_signatory;
    }

    public String getCarrier_requisites() {
        return carrier_requisites;
    }

    public String getShipper_name() {
        return shipper_name;
    }

    public String getShipper_signatory() {
        return shipper_signatory;
    }

    public String getShipper_requisites() {
        return shipper_requisites;
    }

    public String getLoading_place() {
        return loading_place;
    }

    public String getUnloading_place() {
        return unloading_place;
    }

    public String getCargo() {
        return cargo;
    }

    public String getPick_up_date() {
        return pick_up_date;
    }

    public String getPick_down_date() {
        return pick_down_date;
    }

    public String getPrice() {
        return price;
    }

    public boolean getTax() {
        return tax;
    }

    public String getNumber() {
        return number;
    }

    public void setCarrier_name(String carrier_name) {
        this.carrier_name = carrier_name;
    }

    public void setCarrier_signatory(String carrier_signatory) {
        this.carrier_signatory = carrier_signatory;
    }

    public void setCarrier_requisites(String carrier_requisites) {
        this.carrier_requisites = carrier_requisites;
    }

    public void setShipper_name(String shipper_name) {
        this.shipper_name = shipper_name;
    }

    public void setShipper_signatory(String shipper_signatory) {
        this.shipper_signatory = shipper_signatory;
    }

    public void setShipper_requisites(String shipper_requisites) {
        this.shipper_requisites = shipper_requisites;
    }

    public void setLoading_place(String loading_place) {
        this.loading_place = loading_place;
    }

    public void setUnloading_place(String unloading_place) {
        this.unloading_place = unloading_place;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setPick_up_date(String pick_up_date) {
        this.pick_up_date = pick_up_date;
    }

    public void setPick_down_date(String pick_down_date) {
        this.pick_down_date = pick_down_date;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTax(boolean tax) {
        this.tax = tax;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
