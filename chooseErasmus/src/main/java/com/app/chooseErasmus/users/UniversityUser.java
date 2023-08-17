package com.app.chooseErasmus.users;

import jakarta.persistence.*;
import lombok.Data;

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
    private String dean;
}
