package com.gettransport.docs.file;

import com.gettransport.docs.model.Carriage;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.lang.String;

public class CreatingFile {

    private static File fileAgency;
    private static File fileLicense;
    private static File fileCarriage;


    public static void creating(Carriage carriage,TypeContract type){
        switch (type) {
            case AGENCY: agencyCreating(carriage);
            case LICENSE: licenseCreating(carriage);
            case CARRIAGE: carriageCreating(carriage);
        }

    }
    private static void agencyCreating(Carriage carriage){
        File fileFinish = new File("src/main/resources/docs/Agency_contract_" + carriage.getNumber() + ".docx");
        if(carriage.isTax()){ fileAgency = new File("docs/start/Agency_contract/Agency_contract_Enterprise_start.docx");}
        else { fileAgency = new File("src/main/resources/docs/start/Agency_contract/Agency_contract_Business_start.docx");}
        findAndWrite(carriage.getMapAgency(), fileAgency, fileFinish);
    }
    
    private static void licenseCreating(Carriage carriage){
        File fileFinish = new File("src/main/resources/docs/License_contract" + carriage.getNumber() + ".docx");
        fileLicense = new File ("src/main/java/com/gettransport/docs/file/CreatingFile.java");
        findAndWrite(carriage.getMapLicense(), fileLicense, fileFinish);
    }
    private static void carriageCreating(Carriage carriage){
        File fileFinish =  new File("src/main/resources/docs/Contract_of_carriage_" + carriage.getNumber() + ".docx");
        if(carriage.isTax()) fileCarriage = new File("src/main/resources/docs/start/Carriage_contract/Carriage_contract_Enterprise_start.docx");
        else fileCarriage = new File("src/main/resources/docs/start/Carriage_contract/Carriage_contract_Business_start.docx");
        findAndWrite(carriage.getMapCarriage(), fileCarriage, fileFinish);
    }

    private static void findAndWrite (Map<String,String> map, File fileStart, File fileFinish){


        try(FileInputStream fileInputStream = new FileInputStream (fileStart.getCanonicalFile());
            FileOutputStream fileOutputStream = new FileOutputStream(fileFinish)){
            XWPFDocument doc = new XWPFDocument(fileInputStream);
            for(Map.Entry<String, String> entry: map.entrySet()) {
                for (XWPFParagraph p : doc.getParagraphs()) {
                    List<XWPFRun> runs = p.getRuns();
                    if (runs != null) {
                        for (XWPFRun r : runs) {
                            String text = r.getText(0);
                            if (text != null && text.contains(entry.getKey())) {
                                text = text.replace(entry.getKey(), entry.getValue());//your content
                                r.setText(text, 0);
                            }
                        }
                    }
                }
            }
            doc.write(fileOutputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
