package com.example.webfluxdemo.controller;

import com.example.webfluxdemo.model.Person;
import com.example.webfluxdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/{id}")
    public Mono<Person> getPersonById(@PathVariable String id) {
        return personRepository.findById(id);
    }

    @GetMapping
    public Flux<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PostMapping
    public Mono<Person> createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }
}
