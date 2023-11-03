package com.app.chooseErasmus.studyField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studyField")
public class StudyFieldController {
    @Autowired
    private StudyFieldRepository studyFieldRepository;

    @GetMapping(value = "/studyFields")
    public List<StudyField> getStudyFields() {
        return studyFieldRepository.findAll();
    }

    @PostMapping(value = "/save")
    public String saveStudyField(@RequestBody StudyField studyField) {
        studyFieldRepository.save(studyField);
        System.out.println("Saved with ".concat(studyField.toString()));
        return "Saved";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody StudyField studyField) {
        StudyField updatedUniversityUser = studyFieldRepository.findById(id).get();
        updatedUniversityUser.setFullName(studyField.getFullName());
        updatedUniversityUser.setSemesterAmount(studyField.getSemesterAmount());
        studyFieldRepository.save(updatedUniversityUser);
        return "Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        StudyField studyField = studyFieldRepository.findById(id).get();
        studyFieldRepository.delete(studyField);
        return "Deleted";
    }
}
