package com.app.chooseErasmus.universityUser;

import com.app.chooseErasmus.studyField.StudyField;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/universitiesApi")
public class UniversityUserController {

    @Autowired
    private UniversityUserApi universityUserApi;

    @GetMapping(value = "/" +
            "")
    public List<UniversityUser> getUniversityUsers() {
        return universityUserApi.getUniversityUsers();
    }

    @GetMapping(value = "/university/{id}")
    public Optional<UniversityUser> getUniversityUserById(@PathVariable Long id) {
        return universityUserApi.getStudyFieldById(id);
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
    public String deleteUniversityUser(@PathVariable long id){
        universityUserApi.updateUniversityUser(id);
        return "Deleted with".concat(String.valueOf(id));
    }
}
