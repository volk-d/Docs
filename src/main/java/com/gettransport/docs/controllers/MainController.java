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

    private Carriage saveCarriage;

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
    public String carriage (@ModelAttribute("carriage") Carriage carriage,Model model) throws Exception{


        if (
                carriage.getCarrier_name() != null && carriage.getCarrier_name().length() > 0
                && carriage.getCarrier_signatory() != null && carriage.getCarrier_signatory().length() > 0
                && carriage.getCarrier_requisites() != null && carriage.getShipper_requisites().length() > 0
                && carriage.getShipper_name() != null && carriage.getShipper_name().length() > 0
                && carriage.getShipper_signatory() != null && carriage.getCarrier_signatory().length() > 0
                && carriage.getShipper_requisites() != null && carriage.getShipper_requisites().length() > 0
                && carriage.getLoading_place() != null && carriage.getLoading_place().length() > 0
                && carriage.getUnloading_place() != null && carriage.getUnloading_place().length() > 0
                && carriage.getCargo() != null && carriage.getCargo().length() > 0
                && carriage.getPick_up_date() != null && carriage.getPick_up_date().length() > 0
                && carriage.getPick_down_date() != null && carriage.getPick_down_date().length() > 0
                && carriage.getPrice() != null && carriage.getPrice().length() > 0
                && carriage.getNumber() != null && carriage.getNumber().length() > 0
        ){
            saveCarriage = carriage;
            return "redirect:/download";
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "carriage_contract";
        }
    }

    @GetMapping("/download")
    public String downloa( Model model){
        model.addAttribute("carriage",saveCarriage);


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