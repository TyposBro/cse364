package me.typosbro.moshimoshi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import me.typosbro.moshimoshi.collection.Person;

public interface PersonService {

    String save(Person person);

    List<Person> getPersonStartWith(String name);

    String delete(String id);

    // List<Person> getAll();

    List<Person> getPersonByAge(Integer minAge, Integer maxAge);

    Page<Person> search(String name, Integer age, Integer minAge, Integer maxAge, String city, String hobbies,
            Pageable pageable);

}
