package com.example.second.controllers;

import com.example.second.models.Person;
import com.example.second.models.PersonTask;
import com.example.second.models.Task;
import com.example.second.models.repositories.PersonRepo;
import com.example.second.models.repositories.PersonTaskRepo;
import com.example.second.models.repositories.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class MainController {

    @Autowired
    private PersonTaskRepo personTaskRepo;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private TaskRepo taskRepo;

    @GetMapping("/")
    public String main(Model model){
        Iterable<PersonTask> tasks =personTaskRepo.findAll();
        Iterable<Person> persons = personRepo.findAll();
        model.addAttribute("tasks", tasks);
        model.addAttribute("persons", persons);
        return "main";
    }

    @PostMapping("/add")
    public String add(@RequestParam Person person, @RequestParam String description,
                      @RequestParam Date date, Model model){
        Task task = new Task(description, date);
        taskRepo.save(task);
        PersonTask personTask = new PersonTask(person, task);
        personTaskRepo.save(personTask);

        return "redirect:/";
    }

    @PostMapping("/change")
    public String change(@RequestParam Long id, @RequestParam Person person, @RequestParam String description,
                      @RequestParam Date date, Model model){
        if(personTaskRepo.existsById(id)) {
            PersonTask personTask = personTaskRepo.findById(id).get();
            personTaskRepo.delete(personTask);
            personTask.setPerson(person);
            if(!(personTask.getTask().getDescription().equals(description) && personTask.getTask().getDate().equals(date))){
                Task task = new Task(description, date);
                taskRepo.save(task);
                personTask.setTask(task);
            }
            personTaskRepo.save(personTask);
        }

        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String add(@PathVariable(value = "id")Long id, Model model){

        PersonTask personTask = personTaskRepo.findById(id).get();
        taskRepo.delete(personTask.getTask());
        personTaskRepo.delete(personTask);

        return "redirect:/";
    }
}
