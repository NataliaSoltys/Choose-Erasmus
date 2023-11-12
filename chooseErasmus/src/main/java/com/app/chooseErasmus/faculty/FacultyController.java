package com.app.chooseErasmus.faculty;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyApi facultyApi;

    @GetMapping(value = "/faculties")
    public List<Faculty> getFaculties() {
        return facultyApi.getStudyFields();
    }

    @PostMapping(value = "/save")
    public String saveFaculty(@RequestBody Faculty faculty) {
        facultyApi.saveFaculty(faculty);
        return "Saved with ".concat(faculty.toString());
    }

    @PutMapping("/update/{id}")
    public String updateFaculty(@PathVariable long id, @RequestBody Faculty faculty) {
        facultyApi.updateFaculty(id, faculty);
        return "Updated with id: ".concat(String.valueOf(id));
    }

    @DeleteMapping("/delete/{id}")
    public String update(@PathVariable long id) {
        facultyApi.deleteFaculty(id);
        return "Deleted with id: ".concat(String.valueOf(id));
    }
}