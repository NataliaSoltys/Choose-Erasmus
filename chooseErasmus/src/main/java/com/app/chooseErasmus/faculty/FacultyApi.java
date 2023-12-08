package com.app.chooseErasmus.faculty;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class FacultyApi {
    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getStudyFields() {
        return facultyRepository.findAll();
    }

    public List<Faculty> getFacultiesByUniversityId(Long universityId){
        return facultyRepository.findByUniversityId(universityId);
    }

    public void saveFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public void updateFaculty(long id, @RequestBody Faculty faculty) {
        Faculty updateFaculty = facultyRepository.findById(id).get();
        updateFaculty.setFullName(faculty.getFullName());
        updateFaculty.setAddress(faculty.getAddress());
        updateFaculty.setDean(faculty.getDean());
        updateFaculty.setUniversity(faculty.getUniversity());
        facultyRepository.save(updateFaculty);
    }

    public void deleteFaculty(long id) {
        Faculty faculty = facultyRepository.findById(id).get();
        facultyRepository.delete(faculty);
    }

    public Optional<Faculty> getStudyFieldById(long facultyId) {
        return facultyRepository.findById(facultyId);
    }
}
