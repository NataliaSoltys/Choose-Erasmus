package com.app.chooseErasmus.studentUser;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentUserApi {
    @Autowired
    private StudentUserRepository studentUserRepository;

    public List<StudentUser> getStudentUsers() {
        return studentUserRepository.findAll();
    }

    public Optional<StudentUser> getStudentUserById(Long id) {
        return studentUserRepository.findById(id);
    }

    public void saveStudentUser(StudentUser user) {
        studentUserRepository.save(user);
    }

    public void updateStudentUser(long id, StudentUser user) {
        StudentUser updatedUniversityUser = studentUserRepository.findById(id).get();
        updatedUniversityUser.setFullName(user.getFullName());
        updatedUniversityUser.setSemesterAbroad(user.getSemesterAbroad());
        updatedUniversityUser.setStudyField(user.getStudyField());
        studentUserRepository.save(updatedUniversityUser);
    }

    public void deleteStudentUser(long id) {
        StudentUser studentUser = studentUserRepository.findById(id).get();
        studentUserRepository.delete(studentUser);
    }

    public List<StudentUser> getStudentUserByStudyFieldId(Long studyFieldId) {
        return studentUserRepository.findAllByStudyFieldId(studyFieldId);
    }
}
