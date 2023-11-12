package com.app.chooseErasmus.studentUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/studentUser")
public class StudentUserController {
    @Autowired
     private StudentUserApi studentUserApi;

    @GetMapping(value = "/studentUsers")
    public List<StudentUser> getStudentUsers() {
        return studentUserApi.getStudentUsers();
    }

    @GetMapping(value = "/studentUsers/{id}")
    public Optional<StudentUser> getStudentUserById(@PathVariable Long id) {
        return studentUserApi.getStudentUserById(id);
    }

    @PostMapping(value = "/save")
    public String saveStudentUser(@RequestBody StudentUser user) {
       studentUserApi.saveStudentUser(user);
        return "Saved with ".concat(user.toString());

    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody StudentUser user) {
        studentUserApi.updateStudentUser(id, user);

        return "Updated".concat(user.toString());
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        studentUserApi.deleteStudentUser(id);
        return "Deleted student user with id: ".concat(String.valueOf(id));
    }
}
