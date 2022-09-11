package com.example.lesson_02_0910;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
public class Service {
    public static ResponseEntity<List<Person>> sort(String a,String b){
        PersonRepository personRepository = new PersonRepository();
        List<Person> list = personRepository.getAllPerson();
        if (b.equals("asc")){
            if (a.equals("name")){
                list.sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                return ResponseEntity.ok().body(list);
            } else if (a.equals("naitionality")) {
                list.sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getNationality().compareTo(o2.getNationality());
                    }
                });
                return ResponseEntity.ok().body(list);
            }else if (a.equals("age")){
                list.sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getAge()- o2.getAge();
                    }
                });
                return ResponseEntity.ok().body(list);
            }
        }else if (b.equals("desc")){
            if (a.equals("name")){
                list.sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o2.getName().compareTo(o1.getName());
                    }
                });
                return ResponseEntity.ok().body(list);
            } else if (a.equals("naitionality")) {
                list.sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o2.getNationality().compareTo(o1.getNationality());
                    }
                });
                return ResponseEntity.ok().body(list);
            }else if (a.equals("age")){
                list.sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o2.getAge()- o1.getAge();
                    }
                });
                return ResponseEntity.ok().body(list);
            }
        }
        return null;
    }

}
