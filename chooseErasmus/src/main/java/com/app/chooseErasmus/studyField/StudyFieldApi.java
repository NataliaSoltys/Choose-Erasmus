package com.app.chooseErasmus.studyField;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudyFieldApi {
    @Autowired
    private StudyFieldRepository studyFieldRepository;

    public List<StudyField> getStudyFields() {
        return studyFieldRepository.findAll();
    }

    public Optional<StudyField> getStudyFieldById(Long id) {
        return studyFieldRepository.findById(id);
    }

    public void saveStudyField(StudyField studyField) {
        studyFieldRepository.save(studyField);
    }

    public void updateStudyField(long id, StudyField studyField) {
        StudyField updatedUniversityUser = studyFieldRepository.findById(id).get();
        updatedUniversityUser.setFullName(studyField.getFullName());
        updatedUniversityUser.setSemesterAmount(studyField.getSemesterAmount());
        updatedUniversityUser.setFaculty(studyField.getFaculty());
        studyFieldRepository.save(updatedUniversityUser);
    }

    public void deleteStudyField(long id) {
        StudyField studyField = studyFieldRepository.findById(id).get();
        studyFieldRepository.delete(studyField);
    }

    public List<StudyField> getStudyFieldsByFacultyId(Long facultyId) {
        return studyFieldRepository.findAllByFacultyId(facultyId);
    }
}
