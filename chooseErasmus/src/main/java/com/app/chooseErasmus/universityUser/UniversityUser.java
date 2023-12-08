package com.app.chooseErasmus.universityUser;

import com.app.chooseErasmus.faculty.Faculty;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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

    @ManyToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "uni_contracted_uni",
            joinColumns = @JoinColumn(name = "uni_id"),
            inverseJoinColumns = @JoinColumn(name = "contracted_uni_id"))
    private List<UniversityUser> contractedUniversities;

// ---------  set to other entity   ------------
    @OneToMany(mappedBy = "university")
    @JsonIgnore
    @JsonManagedReference(value = "faculties")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Faculty> faculties;

}