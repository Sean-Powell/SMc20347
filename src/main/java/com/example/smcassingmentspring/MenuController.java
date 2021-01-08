package com.example.smcassingmentspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @GetMapping("/adminMenu")
    public String getAdminMenu(){
        return "adminMenu";
    }

    @GetMapping("/studentMenu")
    public String getStudentMenu(){
        return "studentMenu";
    }
}
