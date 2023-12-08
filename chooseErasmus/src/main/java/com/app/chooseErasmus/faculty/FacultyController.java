package com.app.chooseErasmus.faculty;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/facultyApi")
public class FacultyController {
    @Autowired
    private FacultyApi facultyApi;

    @GetMapping(value = "/faculties")
    public List<Faculty> getFaculties() {
        return facultyApi.getStudyFields();
    }

    @GetMapping(value = "/faculties/{facultyId}")
    public Optional<Faculty> getFaculties(@PathVariable long facultyId) {
        return facultyApi.getStudyFieldById(facultyId);
    }

    @GetMapping(value = "/university/{universityId}/faculties")
    public List<Faculty> getFacultiesByUniversityId(@PathVariable long universityId){
        return facultyApi.getFacultiesByUniversityId(universityId);
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
    public String deleteFaculty(@PathVariable long id) {
        facultyApi.deleteFaculty(id);
        return "Deleted with id: ".concat(String.valueOf(id));
    }
}