package com.app.chooseErasmus.studyField;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudyFieldApi {
    @Autowired
    private StudyFieldRepository studyFieldRepository;

    public List<StudyField> getStudyFields() {
        return studyFieldRepository.findAll();
    }

    public void saveStudyField(StudyField studyField) {
        studyFieldRepository.save(studyField);
    }

    public void updateStudyField(long id, StudyField studyField) {
        StudyField updatedUniversityUser = studyFieldRepository.findById(id).get();
        updatedUniversityUser.setFullName(studyField.getFullName());
        updatedUniversityUser.setSemesterAmount(studyField.getSemesterAmount());
        studyFieldRepository.save(updatedUniversityUser);
    }

    public void deleteStudyField(long id) {
        StudyField studyField = studyFieldRepository.findById(id).get();
        studyFieldRepository.delete(studyField);
    }
}
