package com.app.chooseErasmus.faculty;

import com.app.chooseErasmus.studyField.StudyField;
import com.app.chooseErasmus.universityUser.UniversityUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fullName;

    @Column
    private String address;

    @Column
    private String dean;

    @ManyToOne
    @JoinColumn(name = "university_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UniversityUser university;



//  _________________________________________
    @OneToMany(mappedBy = "faculty")
    @JsonIgnore
    @JsonManagedReference(value = "studyFields")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<StudyField> studyFields;

}