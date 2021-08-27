package com.gettransport.docs.model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Signer implements Data {
    private String name, signatory, requisites, number;
    private boolean tax;
    private Carriage monitor1 = new Carriage();
    private Carriage monitor2 = new Carriage();
    private Carriage monitor3 = new Carriage();

    public Signer(){}



    @Override
    public Map<String, String> getMapCarriage() {
        synchronized (monitor1) {
            Map<String, String> variable = new HashMap<>();
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = new Date();
            variable.put("name", name);
            variable.put("signatory", signatory);
            variable.put("requisites", requisites);
            variable.put("tdata", dateFormat.format(date));
            variable.put("number", number);
            return variable;
        }
    }

    @Override
    public Map<String, String> getMapAgency() {
        synchronized (monitor2) {
            Map<String, String> variable = new HashMap<>();
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = new Date();
            variable.put("name", name);
            variable.put("signatory", signatory);
            variable.put("requisites", requisites);
            variable.put("tdata", dateFormat.format(date));
            variable.put("number", number);
            return variable;
        }
    }

    @Override
    public Map<String, String> getMapLicense() {
        synchronized (monitor3) {
            Map<String, String> variable = new HashMap<>();
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = new Date();
            variable.put("name", name);
            variable.put("signatory", signatory);
            variable.put("requisites", requisites);
            variable.put("tdata", dateFormat.format(date));
            variable.put("number", number);
            return variable;
        }
    }

    @Override
    public boolean isTax() {
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
