package com.example.webfluxdemo.repository;

import com.example.webfluxdemo.model.Person;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PersonRepository {

    private final Map<String, Person> personMap = new ConcurrentHashMap<>();

    public PersonRepository() {
        // Prepopulate some data
        personMap.put("1", new Person("1", "John Doe"));
        personMap.put("2", new Person("2", "Jane Doe"));
    }

    public Mono<Person> findById(String id) {
        return Mono.justOrEmpty(personMap.get(id));
    }

    public Flux<Person> findAll() {
        return Flux.fromIterable(personMap.values());
    }

    public Mono<Person> save(Person person) {
        personMap.put(person.getId(), person);
        return Mono.just(person);
    }
}
