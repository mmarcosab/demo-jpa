package com.example.demo.database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonData, Integer> {

    @Query(value = "SELECT p FROM PersonData p ")
    Page<PersonData> getPersons(final Pageable pageable);

}
