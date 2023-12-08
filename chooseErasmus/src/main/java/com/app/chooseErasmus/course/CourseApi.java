package com.app.chooseErasmus.course;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseApi {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public List<Course> getCoursesByStudyFieldId(Long studyFieldId){
        return courseRepository.findAllByStudyFieldId(studyFieldId);
    }

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(long id, Course course) {
        Course updatedCourse = courseRepository.findById(id).get();
        updatedCourse.setFullName(course.getFullName());
        updatedCourse.setCourseCategory(course.getCourseCategory());
        updatedCourse.setSemesterType(course.getSemesterType());
        updatedCourse.setEctsPoints(course.getEctsPoints());
        updatedCourse.setSemester(course.getSemester());
        updatedCourse.setHoursAmount(course.getHoursAmount());
        updatedCourse.setHoursAmount(course.getHoursAmount());
        updatedCourse.setCourseDescription(course.getCourseDescription());
        updatedCourse.setStudyField(course.getStudyField());
        courseRepository.save(updatedCourse);
    }

    public void deleteCourse(long id) {
        Course studentUser = courseRepository.findById(id).get();
        courseRepository.delete(studentUser);
    }
}
