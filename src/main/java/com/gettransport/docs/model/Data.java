package com.gettransport.docs.model;

import java.util.Map;

public interface Data {
     Map<String, String> getMapCarriage();
     Map<String,String>  getMapAgency();
     Map<String,String>  getMapLicense();
     boolean isTax();
}
