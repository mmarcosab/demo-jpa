package com.example.demo.database;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "person")
public class PersonData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "identification_number")
    private String identificationNumber;
    @Column(name = "birth_date")
    private LocalDate birthData;

    public PersonData() {
    }

    public PersonData(Integer id, String firstName, String lastName, String identificationNumber, LocalDate birthData) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.birthData = birthData;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public LocalDate getBirthData() {
        return birthData;
    }
}
