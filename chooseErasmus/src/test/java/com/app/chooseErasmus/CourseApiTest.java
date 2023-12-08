package com.app.chooseErasmus;

import com.app.chooseErasmus.course.Course;
import com.app.chooseErasmus.course.CourseApi;
import com.app.chooseErasmus.course.CourseRepository;
import com.app.chooseErasmus.enums.SemesterType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CourseApiTest {
    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseApi courseApi;

    @Test
    @DisplayName("should return list of courses")
    void shouldReturnListOfCourses() {
        // given: there are already 2 courses created
        Course course1 = new Course();
        Course course2 = new Course();
        //Course course1 = Course.builder().semesterType(SemesterType.SUMMER).build();

        List<Course> mockCourses = Arrays.asList(course1, course2);

        // when: user calls api to find courses
        Mockito.when(courseRepository.findAll()).thenReturn(mockCourses);
        List<Course> result = courseApi.getCourses();

        // then: list of courses is returned
        Assertions.assertEquals(mockCourses, result);
    }
//
//    @Test
//    @DisplayName("should create course")
//    void shouldCreateCourse() {
//        // given:
//        Course courseToCreate = Course.builder()
//                .semesterType(SemesterType.SUMMER)
//                .build();
//
//        // when:
//        courseApi.saveCourse(courseToCreate);
//
//        // then:
//        Mockito.verify(courseRepository, Mockito.times(1)).save(courseToCreate);
//    }
//
//    @Test
//    public void testUpdateCourse() {
//        // given:
//        long courseId = 1L;
//        Course existingCourse = Course.builder()
//                .id(courseId)
//                .fullName("Existing Course")
//                .semesterType(SemesterType.SUMMER)
//                .build();
//        Course updatedCourseData = Course.builder()
//                .fullName("Updated Course")
//                .semesterType(SemesterType.WINTER)
//                .build();
//
//        // when: user wants to update course
//        Mockito.when(courseRepository.findById(courseId)).thenReturn(Optional.of(existingCourse));
//        courseApi.updateCourse(courseId, updatedCourseData);
//
//        //then
//        Mockito.verify(courseRepository, Mockito.times(1)).save(Mockito.any(Course.class));
//        Mockito.verify(courseRepository, Mockito.times(1)).save(existingCourse);
//    }
//
//    @Test
//    public void testDeleteCourse() {
//        //given:
//        long courseId = 1L;
//        Course existingCourse = Course.builder()
//                .id(courseId)
//                .fullName("Existing Course")
//                .semesterType(SemesterType.SUMMER)
//                .build();
//
//        //when:
//        Mockito.when(courseRepository.findById(courseId)).thenReturn(Optional.of(existingCourse));
//        courseApi.deleteCourse(courseId);
//
//        // then
//        Mockito.verify(courseRepository, Mockito.times(1)).delete(existingCourse);
//    }
//
}
