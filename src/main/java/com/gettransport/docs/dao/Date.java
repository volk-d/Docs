package com.gettransport.docs.dao;

import com.gettransport.docs.model.Carriage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Date  {

    private static Map mapCarriages = new ConcurrentHashMap();
    private static Map sessionTime = new ConcurrentHashMap();



    public static void add(String id,Carriage carriage){
        Carriage otherCarriage = (Carriage) mapCarriages.get(id);
        if(otherCarriage != null){
            if(carriage.getNumber() == null) carriage.setNumber(otherCarriage.getNumber());
            if(carriage.getShipper_name() == null) carriage.setShipper_name(otherCarriage.getShipper_name());
            if(carriage.getShipper_signatory() == null) carriage.setShipper_signatory(otherCarriage.getShipper_signatory());
            if(carriage.getShipper_requisites() == null) carriage.setShipper_requisites(otherCarriage.getShipper_requisites());
            if(carriage.getCarrier_name() == null) carriage.setCarrier_name(otherCarriage.getCarrier_name());
            if(carriage.getCarrier_signatory() == null) carriage.setCarrier_signatory(otherCarriage.getCarrier_signatory());
            if(carriage.getCarrier_requisites() == null) carriage.setCarrier_requisites(otherCarriage.getCarrier_requisites());
            if(carriage.getPick_up_date() == null) carriage.setPick_up_date(otherCarriage.getPick_up_date());
            if(carriage.getPick_down_date() == null) carriage.setPick_down_date(otherCarriage.getPick_down_date());
//                        carriage.setTax(otherCarriage.getLoading_place());
//            if(carriage.getUnloading_place() == null) carriage;
//            if(carriage == null) carriage;
//            if(carriage == null) carriage;
//            if(carriage == null) carriage;
//            if(carriage == null) carriage;
//            if(carriage == null) carriage;
            mapCarriages.put(id,carriage);
        } else {
            new Cleaner(id);
            mapCarriages.put(id, carriage);
        }
    }
    public static Carriage get(String id) {
        return (Carriage) mapCarriages.get(id);
    }
    public static void delete(String id){
        mapCarriages.remove(id);
    }
//    public static void change(String id, Carriage carriage) {
//    mapCarriages.put(id, carriage);
//    }



}
