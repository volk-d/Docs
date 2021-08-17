package com.gettransport.docs.model;


import java.util.HashMap;
import java.util.Map;

public class Signer implements Data {
    private String name, signatory, requisites;

    public Signer(){}

    public Signer(String name, String signatory, String requisites) {
        this.name = name;
        this.signatory = signatory;
        this.requisites = requisites;
    }

    @Override
    public Map<String, String> getMap() {
        Map<String,String> variable = new HashMap<>();

        variable.put("name", name);
        variable.put("signatory", signatory);
        variable.put("requisites", requisites);

        return variable;
    }

    @Override
    public boolean isTax() {
        return false;
    }
}
