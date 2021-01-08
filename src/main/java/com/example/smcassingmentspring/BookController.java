package com.example.smcassingmentspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String submitBook(@ModelAttribute Book book, Model model) {
        Book toSave = new Book(book.getBookName());
        toSave = bookRepository.save(toSave);
        return "adminMenu";
    }
}

