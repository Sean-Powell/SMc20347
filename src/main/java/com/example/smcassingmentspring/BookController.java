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
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/bookForm")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        return "bookForm";
    }

    @PostMapping("/bookForm")
    public void submitBook(@ModelAttribute Book book, Model model) {
        System.out.println("Book Name: " + book.getBookName());
        Book toSave = new Book(book.getBookName());
        System.out.println("Created book entity");
        toSave = bookRepository.save(toSave);
        System.out.println("Book Saved");
    }
}

