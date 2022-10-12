package com.example.translate_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class EmailController {
    private ServletContext servletContext;
    public EmailController(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    Email emailData = new Email("Techmaster@gmail.com");
    @GetMapping("/email")
    public  String home(Model model){
        return "email";
    }
    @GetMapping(value = "/email/modelattributes")
    public String emailModel(Model model) {

        model.addAttribute("emailData", emailData);
        return "data";
    }
    @GetMapping(value = "/email/requestparameters")
    @ResponseBody
    public String emailRequestParameters(@RequestParam(value = "emailsubject") String emailSubject) {
        return "requestparameters";
    }
    @GetMapping("/add")
    @ResponseBody
    public int add2(@RequestParam("a") int a, @RequestParam("b") int b) {
        return a + b;
    }

}
