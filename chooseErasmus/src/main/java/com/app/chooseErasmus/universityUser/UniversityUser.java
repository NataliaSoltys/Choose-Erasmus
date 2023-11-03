package com.app.chooseErasmus.universityUser;

import com.app.chooseErasmus.faculty.Faculty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class UniversityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String fullName;

    @Column
    private String city;

    @Column
    private String address;

    @Column
    private String rector;

    /// ???
    @JoinTable
    private List<Long> contractedUniversities;

// ---------  set to other entity   ------------
    @OneToMany(mappedBy = "university")
    @JsonIgnore
    @JsonManagedReference(value = "faculties")
    private List<Faculty> faculties;

//    @ElementCollection
//    @CollectionTable(name = "user_contracted_universities", joinColumns = @JoinColumn(name = "user_id"))
//    @Column(name = "contracted_user_id")
//    private List<Long> contractedUniversities;
}