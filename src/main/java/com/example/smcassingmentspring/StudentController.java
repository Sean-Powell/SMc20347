package com.example.smcassingmentspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public String submitStudent(@ModelAttribute Student student, Model model) {
        studentRepository.save(new Student(student.getStudentName()));
        return "menu";
    }

    @GetMapping("/removeStudent")
    public String removeStudentForm(Model model){
        Iterable<Student> students = studentRepository.findAll();
        List<Student> studentNames = new ArrayList<Student>();
        for(Student s: students){
            if(!s.isRemoved()) {
                studentNames.add(s);
            }
        }
        model.addAttribute("stud", new Student());
        model.addAttribute("studentNames", studentNames);
        return "removeStudent";
    }

    @PostMapping("/removeStudent")
    public String getStudentToRemove(@ModelAttribute("stud") Student student,  Model model){
        Optional<Student> optionalStudent =  studentRepository.findById(student.getStudentID());
        if(optionalStudent.isPresent()){
            Student s = optionalStudent.get();
            s.setRemoved(true);
            studentRepository.save(s);
        }
        return "menu";
    }
}