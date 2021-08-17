package com.gettransport.docs.file;

import com.gettransport.docs.model.Data;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.lang.String;

public class CreatingFile {

    private static File fileAgency;
    private static File fileLicense = new File("docs.docx"); ;
    private static File fileCarriage = new File("docs.docx"); ;
    private static File fileFinish;

    public static void creating(Data data,TypeContract type){
        switch (type) {
            case AGENCY: agencyCreating(data);
            case LICENSE: licenseCreating(data);
            case CARRIAGE: carriageCreating(data);
        }

    }
    private static void agencyCreating(Data data){

        if(data.isTax()){ fileAgency = new File("docs/start/Agency_contract/Agency_contract_Enterprise_start.docx");
                          fileFinish = new File("docs/finish/Agency_contract/Agency_contract_Enterprise.docx");
        }
        else{ fileAgency = new File("docs/start/Agency_contract/Agency_contract_Business_start.docx");
              fileFinish = new File("docs/finish/Agency_contract/Agency_contract_Business.docx");}


        findAndWrite(data.getMap(), fileAgency, fileFinish);

    }
    private static void licenseCreating(Data data){
        fileFinish = new File("docs/start/License_contract_start.docx");
        findAndWrite(data.getMap(), fileLicense, fileFinish);
    }
    private static void carriageCreating(Data data){
        if(data.isTax()) fileCarriage = new File("docs/start/Carriage_contract/Carriage_contract_Enterprise_start.docx");
        else fileCarriage = new File("docs/start/Carriage_contract/Carriage_contract_Business_start.docx");
        findAndWrite(data.getMap(), fileCarriage, fileFinish);
    }

    private static void findAndWrite (Map<String,String> map, File fileStart, File fileFinish){


        try(FileInputStream fileInputStream = new FileInputStream (fileStart.getAbsoluteFile());
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
