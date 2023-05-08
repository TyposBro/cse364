package me.typosbro.moshimoshi.service;

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

}
