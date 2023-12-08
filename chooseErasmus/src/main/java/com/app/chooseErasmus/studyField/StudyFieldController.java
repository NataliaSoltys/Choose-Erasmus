package com.app.chooseErasmus.studyField;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/studyFieldApi")
public class StudyFieldController {
    @Autowired
    private StudyFieldApi studyFieldApi;

    @GetMapping(value = "/studyFields")
    public List<StudyField> getStudyFields() {
        return studyFieldApi.getStudyFields();
    }

    @GetMapping(value = "/studyFields/{id}")
    public Optional<StudyField> getStudyFieldById(@PathVariable Long id) {
        return studyFieldApi.getStudyFieldById(id);
    }

    @GetMapping(value = "/faculty/{facultyId}/studyFields")
    public List<StudyField> getStudyFieldsByFacultyId(@PathVariable Long facultyId){
        return studyFieldApi.getStudyFieldsByFacultyId(facultyId);
    }

    @PostMapping(value = "/save")
    public String saveStudyField(@RequestBody StudyField studyField) {
        studyFieldApi.saveStudyField(studyField);
        return "Saved with ".concat(studyField.toString());
    }

    @PutMapping("/update/{id}")
    public String updateStudyField(@PathVariable long id, @NotNull @RequestBody StudyField studyField) {
        studyFieldApi.updateStudyField(id, studyField);
        return "Updated with id: ".concat(String.valueOf(id));
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        studyFieldApi.deleteStudyField(id);
        return "Deleted with id: ".concat(String.valueOf(id));
    }
}
