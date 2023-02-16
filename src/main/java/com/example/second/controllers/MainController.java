package com.example.second.controllers;

import com.example.second.models.PersonTask;
import com.example.second.models.repositories.PersonTaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private PersonTaskRepo personTaskRepo;

    @GetMapping("/")
    public String main(Model model){
        Iterable<PersonTask> tasks =personTaskRepo.findAll();
        model.addAttribute("tasks", tasks);
        return "main";
    }

    @PostMapping("/add")
    public String add(Model model){

    }
}
