package com.spring.crud.controller;


import com.spring.crud.model.User;
import com.spring.crud.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/users")
public class UserController {

    private final UserService servise;

    public UserController(UserService servise) {
        this.servise = servise;
    }

    @PostMapping
    public User create(@RequestBody User user){
        return servise.Save(user);
    }

    @GetMapping
    public List<User> list() {
        return servise.listAll();
    }

    @GetMapping("/{id}")
    public User search(@PathVariable Long id){
        return servise.SearchById(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user){
        return servise.Update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        servise.delete(id);
    }

}
