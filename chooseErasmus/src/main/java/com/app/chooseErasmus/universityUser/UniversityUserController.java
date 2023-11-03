package com.app.chooseErasmus.universityUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityUserController {

    @Autowired
    private UniversityUserRepository universityUserRepository;

    @GetMapping(value = "/users")
    public List<UniversityUser> getUsers() {
        return universityUserRepository.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody UniversityUser user) {
        universityUserRepository.save(user);
        System.out.println("Saved with ".concat(user.toString()));
        return "Saved";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody UniversityUser user) {
        UniversityUser updatedUniversityUser = universityUserRepository.findById(id).get();
        updatedUniversityUser.setFullName(user.getFullName());
        updatedUniversityUser.setCity(user.getCity());
        updatedUniversityUser.setAddress(user.getAddress());
//        updatedUniversityUser.setDean(user.getDean());
        universityUserRepository.save(updatedUniversityUser);
        return "Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String update(@PathVariable long id){
        UniversityUser deleteUser = universityUserRepository.findById(id).get();
        universityUserRepository.delete(deleteUser);
        return "Deleted";
    }
}
