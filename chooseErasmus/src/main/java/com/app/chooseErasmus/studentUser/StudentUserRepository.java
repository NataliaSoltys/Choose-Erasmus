package com.app.chooseErasmus.studentUser;

import com.app.chooseErasmus.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentUserRepository extends JpaRepository<StudentUser, Long> {
    List<StudentUser> findAllByStudyFieldId(long studyFieldId);
}
