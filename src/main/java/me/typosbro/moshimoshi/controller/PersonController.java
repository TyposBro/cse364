package me.typosbro.moshimoshi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.typosbro.moshimoshi.collection.Person;
import me.typosbro.moshimoshi.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public String save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping
    public List<Person> getPersonsStartWith(@RequestParam("name") String name) {
        return personService.getPersonStartWith(name);

    }

    @GetMapping()
    public List<Person> getAll() {
        return personService.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return personService.delete(id);
    }

}
