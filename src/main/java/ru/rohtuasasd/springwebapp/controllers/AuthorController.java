package ru.rohtuasasd.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rohtuasasd.springwebapp.repository.AuthorRepository;

@Controller
public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        final String authors = "authors";
        model.addAttribute(authors, authorRepository.findAll());
        return authors;
    }
}
