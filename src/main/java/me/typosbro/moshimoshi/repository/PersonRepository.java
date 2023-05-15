package me.typosbro.moshimoshi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import me.typosbro.moshimoshi.collection.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    List<Person> findByFirstNameStartsWith(String name);

    // List<Person> findByAgeBetween(Integer min, Integer max);

    @Query(value = "{'age':{$gt:?0,$lt:?1}}", fields = "{address:0}")
    List<Person> findPersonByAgeBetween(Integer min, Integer max);

}
