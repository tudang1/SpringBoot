package com.example.lesson_06_0919.mapper;

import com.example.lesson_06_0919.model.Car;
import com.example.lesson_06_0919.model.CarPojo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    CarPojo carToPojo(Car car);
    Car pojoToCar(CarPojo poJo);
}
