package me.typosbro.moshimoshi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import me.typosbro.moshimoshi.collection.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    // String getPersonId();

    // String getFirstName();

    // String getLastName();

    // Integer getAge();

    // List<String> getHobbies();

    // List<Address> getAddresses();
}
