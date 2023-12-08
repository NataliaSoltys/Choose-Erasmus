package com.app.chooseErasmus.universityUser;

import com.app.chooseErasmus.faculty.Faculty;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UniversityUserApi {
    @Autowired
    private UniversityUserRepository universityUserRepository;

    public List<UniversityUser> getUniversityUsers() {
        return universityUserRepository.findAll();
    }

    public Optional<UniversityUser> getStudyFieldById(Long id) {
        return universityUserRepository.findById(id);
    }

    public void saveUniversityUser(UniversityUser user) {
        universityUserRepository.save(user);
    }

    public void updateUniversityUser(long id, UniversityUser user) {
        UniversityUser updatedUniversityUser = universityUserRepository.findById(id).get();
        updatedUniversityUser.setFullName(user.getFullName());
        updatedUniversityUser.setCity(user.getCity());
        updatedUniversityUser.setAddress(user.getAddress());
        updatedUniversityUser.setRector(user.getRector());
        universityUserRepository.save(updatedUniversityUser);
    }

    public void updateUniversityUser(long id){
        UniversityUser deleteUser = universityUserRepository.findById(id).get();
        universityUserRepository.delete(deleteUser);
    }
}