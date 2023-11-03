package com.app.chooseErasmus.faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyRepository facultyRepository;

    @GetMapping(value = "/faculties")
    public List<Faculty> getStudyFields() {
        return facultyRepository.findAll();
    }

    @PostMapping(value = "/save")
    public String saveFaculty(@RequestBody Faculty faculty) {
        facultyRepository.save(faculty);
        System.out.println("Saved with ".concat(faculty.toString()));
        return "Saved";
    }

    @PutMapping("/update/{id}")
    public String updateFaculty(@PathVariable long id, @RequestBody Faculty faculty) {
        Faculty updateFaculty = facultyRepository.findById(id).get();
        updateFaculty.setFullName(faculty.getFullName());
        facultyRepository.save(updateFaculty);
        return "Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String update(@PathVariable long id) {
        Faculty faculty = facultyRepository.findById(id).get();
        facultyRepository.delete(faculty);
        return "Deleted";
    }
}
