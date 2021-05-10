package com.example.dopamine.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dopamine.domain.toDo;
import com.example.dopamine.repositories.toDoRepository;

@Controller

public class toDoController {
    @Autowired
    toDoRepository todoRepository;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/todos")
    public String todos(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todos";
    }

    @PostMapping("/todoNew")
    public String add(@RequestParam String todoItem, @RequestParam String status, Model model) {
        toDo todo = new toDo();
        todo.setTodoItem(todoItem);
        todo.setCompleted(status);
        todoRepository.save(todo);
        model.addAttribute("todos", todoRepository.findAll());
        return "redirect:/todos";
    }

    @PostMapping("/todoDelete/{id}")
    public String delete(@PathVariable long id, Model model) {
        todoRepository.deleteById(id);
        model.addAttribute("todos", todoRepository.findAll());
        return "redirect:/todos";
    }

    @PostMapping("/todoUpdate/{id}")
    public String update(@PathVariable long id, Model model) {
        toDo todo = todoRepository.findById(id).get();
        if("Yes".equals(todo.getCompleted())) {
            todo.setCompleted("No");
        }
        else {
            todo.setCompleted("Yes");
        }
        todoRepository.save(todo);
        model.addAttribute("todos", todoRepository.findAll());
        return "redirect:/todos";
    }

}
