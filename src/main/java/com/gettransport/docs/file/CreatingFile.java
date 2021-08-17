package com.gettransport.docs.file;

import com.gettransport.docs.model.Data;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.List;

public class CreatingFile {

    public static void creating(Data data,TypeContract type){
        switch (type) {
            case AGENCY: agencyCreating(data);
            case LICENSE: licenseCreating(data);
            case CARRIAGE: carriageCreating(data);
        }

    }
    private static void agencyCreating(Data data){

    }
    private static void licenseCreating(Data data){}
    private static void carriageCreating(Data data){}

    private static void findAndWrite (String find){
        File file = new File("docs.docx");

        try(FileInputStream fileInputStream = new FileInputStream (file.getAbsoluteFile());
            FileOutputStream fileOutputStream = new FileOutputStream("docsGet.docx")){
            XWPFDocument doc = new XWPFDocument(fileInputStream);

            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains("name")) {
                            text = text.replace("name", "zaika");//your content
                            r.setText(text, 0);
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
