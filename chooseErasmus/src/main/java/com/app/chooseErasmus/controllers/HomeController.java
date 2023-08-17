package com.app.chooseErasmus.controllers;

import com.app.chooseErasmus.repositories.UserRepository;
import com.app.chooseErasmus.users.UniversityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<UniversityUser> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody UniversityUser user) {
        userRepository.save(user);
        System.out.println("Saved with ".concat(user.toString()));
        return "Saved";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody UniversityUser user) {
        UniversityUser updatedUniversityUser = userRepository.findById(id).get();
        updatedUniversityUser.setFullName(user.getFullName());
        updatedUniversityUser.setCity(user.getCity());
        updatedUniversityUser.setAddress(user.getAddress());
        updatedUniversityUser.setDean(user.getDean());
        userRepository.save(updatedUniversityUser);
        return "Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String update(@PathVariable long id){
        UniversityUser deleteUser = userRepository.findById(id).get();
        userRepository.delete(deleteUser);
        return "Deleted";
    }
}
