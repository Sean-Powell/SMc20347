package com.example.smcassingmentspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Controller
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/studentForm")
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @PostMapping("/studentForm")
    public void submitStudent(@ModelAttribute Student student, Model model) {
        studentRepository.save(new Student(student.getStudentName()));
    }
}