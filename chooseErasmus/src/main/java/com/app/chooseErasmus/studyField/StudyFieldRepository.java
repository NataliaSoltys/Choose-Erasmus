package com.app.chooseErasmus.studyField;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyFieldRepository extends JpaRepository<StudyField, Long> {

    // TODO: metoda do pobierania mapy ze sotaje caly cykl studiow
}
