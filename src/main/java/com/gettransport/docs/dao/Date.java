package com.gettransport.docs.dao;

import com.gettransport.docs.model.Carriage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Date  {

    private static Map mapCarriages = new ConcurrentHashMap();
    private static Map sessionTime = new ConcurrentHashMap();



    public static void add(String id,Carriage carriage){
        mapCarriages.put(id,carriage);
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
