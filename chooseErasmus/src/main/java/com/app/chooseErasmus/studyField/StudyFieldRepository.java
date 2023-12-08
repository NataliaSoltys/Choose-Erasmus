package com.app.chooseErasmus.studyField;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyFieldRepository extends JpaRepository<StudyField, Long> {
    List<StudyField> findAllByFacultyId(Long facultyId);
}
