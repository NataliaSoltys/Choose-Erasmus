package com.app.chooseErasmus.universityUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/universities")
public class UniversityUserController {

    @Autowired
    private UniversityUserApi universityUserApi;

    @GetMapping(value = "/users")
    public List<UniversityUser> getUniversityUsers() {
        return universityUserApi.getUniversityUsers();
    }

    @PostMapping(value = "/save")
    public String saveUniversityUser(@RequestBody UniversityUser user) {
        universityUserApi.saveUniversityUser(user);
        return "Saved with ".concat(user.toString());
    }

    @PutMapping("/update/{id}")
    public String updateUniversityUser(@PathVariable long id, @RequestBody UniversityUser user) {
        universityUserApi.updateUniversityUser(id, user);
        return "Updated with ".concat(user.toString());
    }

    @DeleteMapping("/delete/{id}")
    public String updateUniversityUser(@PathVariable long id){
        universityUserApi.updateUniversityUser(id);
        return "Deleted with".concat(String.valueOf(id));
    }
}
