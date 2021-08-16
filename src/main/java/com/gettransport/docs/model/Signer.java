package com.gettransport.docs.model;


public class Signer {
    String name, signatory, requisites;

    public Signer(){}

    public Signer(String name, String signatory, String requisites) {
        this.name = name;
        this.signatory = signatory;
        this.requisites = requisites;
    }
}
