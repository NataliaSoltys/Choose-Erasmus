package com.app.chooseErasmus.course;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/courseApi")
public class CourseController {
    @Autowired
    private CourseApi courseApi;

    @GetMapping(value = "/courses")
    public List<Course> getCourses() {
        return courseApi.getCourses();
    }

    @GetMapping(value = "/courses/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return courseApi.getCourseById(id);
    }

    @GetMapping(value = "/studyField/{studyFieldId}/courses")
    public List<Course> getCoursesByStudyFieldId(@PathVariable Long studyFieldId){
        return courseApi.getCoursesByStudyFieldId(studyFieldId);
    }

    @PostMapping(value = "/save")
    public String saveCourse(@RequestBody Course course) {
        courseApi.saveCourse(course);
        return "Saved with id: ".concat(course.toString());
    }

    @PutMapping("/update/{id}")
    public String updateCourse(@PathVariable long id, @RequestBody Course course) {
        courseApi.updateCourse(id, course);
        return "Updated with id: ".concat(course.toString());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable long id) {
        courseApi.deleteCourse(id);
        return "Deleted with id: ".concat(String.valueOf(id));
    }
}