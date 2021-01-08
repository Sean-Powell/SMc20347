package com.example.smcassingmentspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Controller
public class LoanController{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LoanRepository loanRepository;

    @GetMapping("/loanBook")
    public String loanBook(Model model){
        Iterable<Student> students = studentRepository.findAll();
        Iterable<Book> books = bookRepository.findAll();

        List<Student> studentList = new ArrayList<Student>();
        for(Student s: students){
            if(!s.isRemoved()) {
                studentList.add(s);
            }
        }

        List<Book> bookList = new ArrayList<Book>();
        for(Book b: books){
            bookList.add(b);
        }

        model.addAttribute("loan", new Loan());
        model.addAttribute("studentList", studentList);
        model.addAttribute("bookList", bookList);
        return "loanBook";
    }

    @PostMapping("/loanBook")
    public String getLoanToAdd(@ModelAttribute("loan") Loan loan){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(loan.getExpirationDate());
        loanRepository.save(new Loan((int) loan.getBookID(), (int) loan.getStudentID(), formattedDate));
        return "studentMenu";
    }
}
