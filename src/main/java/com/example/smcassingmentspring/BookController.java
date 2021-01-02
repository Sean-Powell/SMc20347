package com.example.smcassingmentspring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @GetMapping("/bookForm")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        return "bookForm";
    }

    @PostMapping("/bookForm")
    public void submitBook(@ModelAttribute Book book, Model model) {
        System.out.println("Book Name: " + book.getBookName());
    }

}

