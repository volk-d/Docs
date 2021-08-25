package com.gettransport.docs.controllers;

import com.gettransport.docs.file.CreatingFile;
import com.gettransport.docs.file.TypeContract;
import com.gettransport.docs.model.Carriage;
import com.gettransport.docs.model.Signer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;

@Controller
public class MainController {

    private Carriage carriage;

    @Value("${error.message}")
    private String errorMessage;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("carriage", new Carriage());
        return "carriage_contract";
    }

//    @GetMapping("/agency_contract")
//    public String agency_contract(Model model) {
//        model.addAttribute("post", new Signer());
//        return "agency_contract";
//    }
//
//    @GetMapping("/license_agreement")
//    public String license_agreement(Model model) {
//
//        return "license_agreement";
//    }
//
//    @GetMapping("/carriage_contract")
//    public String carriage_contract(Model model) {
//
//        return "carriage_contract";
//    }

//    @PostMapping("/shipper")
//    public String agent(@RequestParam("shipper_name") String shipper_name,
//                        @RequestParam("shipper_signatory") String shipper_signatory,
//                        @RequestParam("shipper_requisites") String shipper_requisites){
//        System.out.println(shipper_name);
//        System.out.println(shipper_signatory);
//        System.out.println(shipper_requisites);
//        return "agency_contract";
//    }
//    @PostMapping("/carrier")
//    public String licensed( @RequestParam("carrier_name") String carrier_name,
//                            @RequestParam("carrier_signatory") String carrier_signatory,
//                            @RequestParam("carrier_requisites") String carrier_requisites){
//        System.out.println(carrier_name);
//        System.out.println(carrier_signatory);
//        System.out.println(carrier_requisites);
//        return "license_agreement";
//    }

    @PostMapping("/carriage")
    public String carriage (
                            @RequestParam("carrier_name") String carrier_name,
                            @RequestParam("carrier_signatory") String carrier_signatory,
                            @RequestParam("carrier_requisites") String carrier_requisites,
                            @RequestParam("shipper_name") String shipper_name,
                            @RequestParam("shipper_signatory") String shipper_signatory,
                            @RequestParam("shipper_requisites") String shipper_requisites,
                            @RequestParam("loading_place") String loading_place,
                            @RequestParam("unloading_place") String unloading_place,
                            @RequestParam("cargo") String cargo,
                            @RequestParam("pick_up_date") String pick_up_date,
                            @RequestParam("pick_down_date") String pick_down_date,
                            @RequestParam("price") String price,
                            @RequestParam("tax") String tax,
                            @RequestParam("number") String number,
                            Model model) throws Exception{
        System.out.println(model.getAttribute("carriage"));


        if (
                carrier_name != null && carrier_name.length() > 0
                && carrier_signatory != null && carrier_signatory.length() > 0
                && carrier_requisites != null && carrier_requisites.length() > 0
                && shipper_name != null && shipper_name.length() > 0
                && shipper_signatory != null && shipper_signatory.length() > 0
                && shipper_requisites != null && shipper_requisites.length() > 0
                && loading_place != null && loading_place.length() > 0
                && unloading_place != null && unloading_place.length() > 0
                && cargo != null && cargo.length() > 0
                && pick_up_date != null && pick_up_date.length() > 0
                && pick_down_date != null && pick_down_date.length() > 0
                && price != null && price.length() > 0
                && number != null && number.length() > 0
        ){

//            carriage = new Carriage(
//                    carrier_name,
//                    carrier_signatory,
//                    carrier_requisites,
//                    shipper_name,
//                    shipper_signatory,
//                    shipper_requisites,
//                    loading_place,
//                    unloading_place,
//                    cargo,
//                    pick_up_date,
//                    pick_down_date,
//                    price,
//
//                    number);


            return "redirect:/download";
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "carriage_contract";
        }
    }

    @GetMapping("/download")
    public String download(Model model){

//        Carriage carriagePrint = (Carriage) model.addAttribute("carriage");

        return "download";
    }

    @RequestMapping("/file")
    public void downloadPDFResource(@ModelAttribute("carriage") Carriage carriage, HttpServletResponse response) throws IOException {

        System.out.println(carriage);
        CreatingFile.creating(carriage, TypeContract.CARRIAGE);
        File file = new File("src/main/resources/docs/docsGet.docx");
        if (file.exists()) {

            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }

            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
            response.setContentLength((int) file.length());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
            file.delete();

        }
    }
}