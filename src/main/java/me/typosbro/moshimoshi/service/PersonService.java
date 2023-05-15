package me.typosbro.moshimoshi.service;

import java.util.List;

import me.typosbro.moshimoshi.collection.Person;

public interface PersonService {

    String save(Person person);

    List<Person> getPersonStartWith(String name);

    String delete(String id);

    List<Person> getAll();

}
