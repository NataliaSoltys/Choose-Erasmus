package com.app.chooseErasmus.faculty;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByUniversityId(Long universityId);
}
