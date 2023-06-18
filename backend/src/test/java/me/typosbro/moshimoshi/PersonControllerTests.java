package me.typosbro.moshimoshi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import me.typosbro.moshimoshi.collection.Person;
import me.typosbro.moshimoshi.controller.PersonController;
import me.typosbro.moshimoshi.service.PersonService;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class PersonControllerTests {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    private List<Person> personList1;

    @BeforeAll
    public void setup() {
        personList1 = new ArrayList<>();
        List<String> hobbies1 = Arrays.asList("Gaming", "Discord");
        Person person1 = Person
                .builder()
                .id("1")
                .firstName("John")
                .lastName("Doe")
                .age(25)
                .hobbies(hobbies1)
                .build();

        List<String> hobbies2 = Arrays.asList("Coding", "J-Pop");
        Person person2 = Person
                .builder()
                .id("2")
                .firstName("Alice")
                .lastName("Partner")
                .age(30)
                .hobbies(hobbies2)
                .build();

        personList1.add(person1);
        personList1.add(person2);
    }

    @Test
    public void testGetPersonsStartWith() {
        when(personService.getPersonStartWith("J")).thenReturn(personList1);
        List<Person> result = personController.getPersonsStartWith("J");
        assertEquals(personList1, result);
    }

    @Test
    public void testGetPersonByAge() {
        when(personService.getPersonByAge(20, 30)).thenReturn(personList1);
        List<Person> result = personController.getPersonByAge(20, 30);
        assertEquals(personList1, result);
    }

    @Test
    public void testSearchPerson() {
        PageImpl<Person> personPage = new PageImpl<>(personList1, PageRequest.of(0, 10), personList1.size());
        when(personService.search(null, null, null, null, null, PageRequest.of(0, 10))).thenReturn(personPage);
        Page<Person> result = personController.searchPerson(null, null, null, null, null, 0, 10);
        assertEquals(personPage, result);
    }
}
