package com.example.translate_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TranslateController {
    @GetMapping("/")
    public String index() {
        // Trả về file index.html
        return "index";
    }
}
