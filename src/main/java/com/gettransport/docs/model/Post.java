package com.gettransport.docs.model;

import org.springframework.web.bind.annotation.RequestParam;

public class Post {
    String carrier_name, carrier_signatory, carrier_requisites;


    public Post(String carrier_name, String carrier_signatory, String carrier_requisites) {
        this.carrier_name = carrier_name;
        this.carrier_signatory = carrier_signatory;
        this.carrier_requisites = carrier_requisites;
    }
}
