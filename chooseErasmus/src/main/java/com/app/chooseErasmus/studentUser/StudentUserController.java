package com.app.chooseErasmus.studentUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studentUser")
public class StudentUserController {
    @Autowired
    private StudentUserRepository studentUserRepository;

    @GetMapping(value = "/studentUsers")
    public List<StudentUser> getStudentUsers() {
        return studentUserRepository.findAll();
    }

    @GetMapping(value = "/studentUsers/{id}")
    public Optional<StudentUser> getStudentUserById(@PathVariable Long id) {
        return studentUserRepository.findById(id);
    }

    @PostMapping(value = "/save")
    public String saveStudentUser(@RequestBody StudentUser user) {
        studentUserRepository.save(user);
        System.out.println("Saved with ".concat(user.toString()));
        return "Saved";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody StudentUser user) {
        StudentUser updatedUniversityUser = studentUserRepository.findById(id).get();
        updatedUniversityUser.setFullName(user.getFullName());
        updatedUniversityUser.setSemesterAbroad(user.getSemesterAbroad());
        updatedUniversityUser.setStudyField(user.getStudyField());
        studentUserRepository.save(updatedUniversityUser);
        return "Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        StudentUser studentUser = studentUserRepository.findById(id).get();
        studentUserRepository.delete(studentUser);
        return "Deleted";
    }
}
