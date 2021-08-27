package com.gettransport.docs.controllers;

import com.gettransport.docs.dao.Date;
import com.gettransport.docs.file.CreatingFile;
import com.gettransport.docs.file.TypeContract;
import com.gettransport.docs.model.Carriage;
import com.gettransport.docs.model.Signer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    private Carriage savCarriage;

    @Value("${error.message}")
    private String errorMessage;

    @GetMapping("/")
    public String index(){
        return "redirect:/carriage";
    }



    //Агентский договор

    @GetMapping("/agency_contract")
    public String agency_contract(Model model, HttpSession session) {
        Carriage carriage = Date.get(session.getId());
        if (carriage != null){
            model.addAttribute("carriage", carriage);
        } else {
            model.addAttribute("carriage", new Carriage());
        }
        return "forms/agency_contract";
    }

    @PostMapping("/agency")
    public String agent(@ModelAttribute("carriage")
                                    Carriage carriage,
                                    Model model,
                                    HttpSession session) throws Exception{
        System.out.println(carriage);
        if (
                carriage.getCarrier_name() != null && carriage.getCarrier_name().length() > 0
                        && carriage.getCarrier_signatory() != null && carriage.getCarrier_signatory().length() > 0
                        && carriage.getCarrier_requisites() != null && carriage.getCarrier_requisites().length() > 0
                        && carriage.getNumber() != null && carriage.getNumber().length() > 0
        ){
            Date.add(session.getId(),carriage);
            return "redirect:/agency_download";
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "forms/agency_contract";
        }
    }
    @GetMapping("/agency_download")
    public String agency_download(ModelMap model,
                                    HttpSession session){
        if(Date.get(session.getId()) != null) {
            Carriage carriage = Date.get(session.getId()); //надо написать если уже такого нет
            model.addAttribute("carriage", carriage);
            return "downloads/agency_download";
        }
        else {
            return "redirect:/agency";
        }
    }

    //Лицензионный договор
    @GetMapping("/license_contract")
    public String license_contract(Model model, HttpSession session) {
        Carriage carriage = Date.get(session.getId());
        if (carriage != null){
            model.addAttribute("carriage", carriage);
        } else {
            model.addAttribute("carriage", new Carriage());
        }
        return "forms/license_contract";
    }

    @PostMapping("/carrier")
    public String licensed(@ModelAttribute("carriage")
                                        Carriage carriage,
                                        Model model,
                                        HttpSession session) throws Exception{
        if (
                           carriage.getShipper_name() != null && carriage.getShipper_name().length() > 0
                        && carriage.getShipper_signatory() != null && carriage.getShipper_signatory().length() > 0
                        && carriage.getShipper_requisites() != null && carriage.getShipper_requisites().length() > 0
                        && carriage.getNumber() != null && carriage.getNumber().length() > 0
        ){
            Date.add(session.getId(),carriage);
            return "redirect:/downloads/license_download";
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "forms/license_agreement";
        }
    }

    @GetMapping("/license_download")
    public String license_download(ModelMap model,
                                   HttpSession session){
        if(Date.get(session.getId()) != null) {
            Carriage carriage = Date.get(session.getId()); //надо написать если уже такого нет
            model.addAttribute("carriage", carriage);
            return "downloads/license_download";
        }
        else {
            return "redirect:/carriage";
        }
    }

    //Договор перевозки

    @GetMapping("/carriage")
    public String index(Model model, HttpSession session) {
        Carriage carriage = Date.get(session.getId());
        if (carriage != null){
            model.addAttribute("carriage", carriage);
        } else {
            model.addAttribute("carriage", new Carriage());
        }
        return "forms/carriage_contract";
    }

    @PostMapping("/carriage")
    public String carriage (@ModelAttribute("carriage")
                                        Carriage carriage,
                                        Model model,
                                        HttpSession session) throws Exception{

        if (
                   carriage.getCarrier_name() != null && carriage.getCarrier_name().length() > 0
                && carriage.getCarrier_signatory() != null && carriage.getCarrier_signatory().length() > 0
                && carriage.getCarrier_requisites() != null && carriage.getCarrier_requisites().length() > 0
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
            Date.add(session.getId(),carriage);
            return "redirect:/carriage_download";
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "forms/carriage_contract";
        }

    }

    @GetMapping("/carriage_download")
    public String carriage_download(ModelMap model,
                           HttpSession session){
        if(Date.get(session.getId()) != null) {
            Carriage carriage = Date.get(session.getId()); //надо написать если уже такого нет
            model.addAttribute("carriage", carriage);
            return "downloads/carriage_download";
        }
        else {
            return "redirect:/carrier";
        }
    }

    //Скачка файлв

    @RequestMapping("/carriage_file")
    public void downloadContractOfCarriage(HttpSession session,
                                    HttpServletResponse response) throws IOException {
        Carriage carriage = Date.get(session.getId());
        System.out.println(carriage);
        CreatingFile.creating(carriage, TypeContract.CARRIAGE);
        String nameFileOut = "src/main/resources/docs/Contract_of_carriage_" + carriage.getNumber() + ".docx";
        File file = new File(nameFileOut);
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
    @RequestMapping("/agent_file")
    public void downloadContractAgency(HttpSession session,
                                    HttpServletResponse response) throws IOException {
        Carriage carriage = Date.get(session.getId());
        System.out.println(carriage);
        CreatingFile.creating(carriage, TypeContract.AGENCY);
        String nameFileOut = "src/main/resources/docs/Agency_contract_" + carriage.getNumber() + ".docx";
        File file = new File(nameFileOut);
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
    @RequestMapping("/license_file")
    public void downloadContractLicense(HttpSession session,
                                       HttpServletResponse response) throws IOException {
        Carriage carriage = Date.get(session.getId());
        CreatingFile.creating(carriage, TypeContract.LICENSE);
        String nameFileOut = "src/main/resources/docs/License_contract_" + carriage.getNumber() + ".docx";
        File file = new File(nameFileOut);
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