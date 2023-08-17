package com.app.chooseErasmus.repositories;

import com.app.chooseErasmus.users.UniversityUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UniversityUser, Long> {
}
