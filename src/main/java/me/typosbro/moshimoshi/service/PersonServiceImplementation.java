package me.typosbro.moshimoshi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.typosbro.moshimoshi.collection.Person;
import me.typosbro.moshimoshi.repository.PersonRepository;

@Service
public class PersonServiceImplementation implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public String save(Person person) {

        return personRepository.save(person).getPersonId();
    }

    @Override
    public List<Person> getPersonStartWith(String name) {
        return personRepository.findByFirstNameStartsWith(name);
    }

    // @Override
    // public List<Person> getAll() {
    // return personRepository.findAll();
    // }

    @Override
    public String delete(String id) {
        personRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Person> getPersonByAge(Integer minAge, Integer maxAge) {
        return personRepository.findPersonByAgeBetween(minAge, maxAge);
    }

}
