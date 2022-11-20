package com.example.demo.controllers;

import com.example.demo.database.PersonData;
import com.example.demo.database.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping(value = "pageable")
    public ResponseEntity<?> getPersonsPageable(
            @RequestParam(defaultValue = "0") final Integer pageNumber,
            @RequestParam(defaultValue = "5") final Integer size
    ) {
        return ResponseEntity.ok(convertToResponse(personRepository.getPersons(PageRequest.of(pageNumber, size))));
    }

    private Map<String, Object> convertToResponse(final Page<PersonData> pagePersons) {
        Map<String, Object> response = new HashMap<>();
        response.put("persons", pagePersons.getContent());
        response.put("current-page", pagePersons.getNumber());
        response.put("total-items", pagePersons.getTotalElements());
        response.put("total-pages", pagePersons.getTotalPages());
        return response;
    }

    @GetMapping
    public ResponseEntity<?> getPersons() {
        return ResponseEntity.ok(personRepository.findAll());
    }
}