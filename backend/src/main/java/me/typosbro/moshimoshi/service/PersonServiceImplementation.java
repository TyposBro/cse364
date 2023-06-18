package me.typosbro.moshimoshi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import me.typosbro.moshimoshi.collection.Person;
import me.typosbro.moshimoshi.repository.PersonRepository;

@Service
public class PersonServiceImplementation implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String save(Person person) {

        return personRepository.save(person).getId();
    }

    @Override
    public List<Person> getPersonStartWith(String name) {
        return personRepository.findByFirstNameStartsWith(name);
    }

    @Override
    public String delete(String id) {
        personRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Person> getPersonByAge(Integer minAge, Integer maxAge) {
        return personRepository.findPersonByAgeBetween(minAge, maxAge);
    }

    @Override
    public Page<Person> search(String name, Integer age, Integer minAge, Integer maxAge, String hobbies,
            Pageable pageable) {

        Query query = new Query().with(pageable);
        List<Criteria> criterias = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            criterias.add(Criteria.where("firstName").regex(name, "i"));
        }

        if (minAge != null && maxAge != null) {
            criterias.add(Criteria.where("age").gte(minAge).lte(maxAge));
        }

        if (hobbies != null && !hobbies.isEmpty()) {
            List<String> hobbiesList = Arrays.asList(hobbies.split(","));
            criterias.add(Criteria.where("hobbies").in(hobbiesList));
        }

        if (!criterias.isEmpty()) {
            Criteria criteria = new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()]));
            query.addCriteria(criteria);
        }

        Page<Person> people = PageableExecutionUtils.getPage(mongoTemplate.find(query, Person.class), pageable,
                () -> mongoTemplate.count(query.skip(0).limit(0), Person.class));

        return people;

    }

}
