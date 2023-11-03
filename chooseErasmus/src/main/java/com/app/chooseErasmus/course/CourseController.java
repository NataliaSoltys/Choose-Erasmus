package com.app.chooseErasmus.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @GetMapping(value = "/courses/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id);
    }

//    @GetMapping(value = "/courses/search")
//    public List<Course> findByRequestParams(@ModelAttribute Course courseParams) {
//        return courseRepository.findCoursesByParams(courseParams);
//    }

    @PostMapping(value = "/save")
    public String saveCourse(@RequestBody Course course) {
        courseRepository.save(course);
        System.out.println("Saved with ".concat(course.toString()));
        return "Saved";
    }

    @PutMapping("/update/{id}")
    public String updateCourse(@PathVariable long id, @RequestBody Course course) {
        Course updatedCourse = courseRepository.findById(id).get();
// TODO
        courseRepository.save(updatedCourse);
        return "Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Course studentUser = courseRepository.findById(id).get();
        courseRepository.delete(studentUser);
        return "Deleted";
    }
}
