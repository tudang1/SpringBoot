package com.example.lesson_04_0914_thymeleaf.mapper;


import com.example.lesson_04_0914_thymeleaf.model.Person;
import com.example.lesson_04_0914_thymeleaf.model.PersonPojo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    PersonMapper personToPojo(Person customer);
    Person pojoToPerson(PersonPojo poJo);
}
