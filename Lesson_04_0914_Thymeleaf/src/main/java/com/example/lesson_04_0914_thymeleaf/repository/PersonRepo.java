package com.example.lesson_04_0914_thymeleaf.repository;

import com.example.lesson_04_0914_thymeleaf.mapper.PersonMapper;
import com.example.lesson_04_0914_thymeleaf.model.Person;
import com.example.lesson_04_0914_thymeleaf.model.PersonPojo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonRepo {
    private List<Person> people;
    public PersonRepo() {
        people = new ArrayList<>(List.of(
                new Person(1,"Dang Hong Tu","Maketting","Male","20-12-1995"),
                new Person(1,"Dang Hong A","fuho","Female","20-12-2000"),
                new Person(1,"Dang Van B","Sale","Male","09-03-1997")));

    }
    public List<Person> getPeople() {
        return people;
    }
    public Person findById(Integer id){
        return people.stream().filter(c->c.getId()==id).findFirst().orElse(null);
    }
    public Person update(Integer id, PersonPojo pojo){
        Person update_person = PersonMapper.INSTANCE.pojoToPerson(pojo);
        update_person.setId(id);
        people= people.stream().map(c->{
            if(c.getId()==id) return update_person;
            else return c;
        }).collect(Collectors.toList());
        return update_person;
    }
    public Person save(PersonPojo pojo){
        Person customer = PersonMapper.INSTANCE.pojoToPerson(pojo);
        Person lastCustomer = people.get(people.size() - 1);
        var id = lastCustomer.getId() + 1;
        customer.setId(id);
        people.add(customer);
        return customer;
    }
    public Person create(Person customer){
        int id;
        if (people.isEmpty()) {
            id = 1;
        } else {
            Person lastCustomer = people.get(people.size() - 1);
            id = lastCustomer.getId() + 1;
        }
        customer.setId(id);
        people.add(customer);
        return customer;
    }
    public Person delete(Integer id){
        Optional<Person> customer = people.stream().filter(c->c.getId()==id).findFirst();
        if(customer.isPresent()){
            people.remove(customer.get());
            return customer.get();
        }
        return null;
    }

}
