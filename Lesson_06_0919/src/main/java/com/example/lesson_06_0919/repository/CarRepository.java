package com.example.lesson_06_0919.repository;

import com.example.lesson_06_0919.mapper.CarMapper;
import com.example.lesson_06_0919.model.Car;
import com.example.lesson_06_0919.model.CarPojo;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CarRepository {
    private List<Car> cars = new ArrayList<>();

    public CarRepository(){
        List<Car> list = new ArrayList<>();
        list.add(new Car(1,"Chrysler","Sebring", "car_1"));
        list.add(new Car(2,"Ford","Econoline E250", "car_2"));
        list.add(new Car(3,"Toyota","Tacoma", "car_3"));
        list.add(new Car(4,"Mitsubishi","Galant", "car_4"));
        list.add(new Car(5,"Honda","Odyssey", "car_5"));
    }
    public List<Car> getAllCar(){
        return cars;
    }
    public Car findById(Integer id){
        return cars.stream().filter(c->c.getId()==id).findFirst().orElse(null);
    }
    public Car findByName(String brand){
        return cars.stream().filter(c->c.getBrand().contains(brand)).findAny().orElse(null);
    }
    public Car findManufacturer(String manufacturer){
        return cars.stream().filter(c->c.getManufacturer().contains(manufacturer)).findAny().orElse(null);
    }
    public Car update(Integer id, CarPojo pojo){
        Car updateCas = CarMapper.INSTANCE.pojoToCar(pojo);
        updateCas.setId(id);
        //tìm id để update
        cars = cars.stream().map(c->{
            if(c.getId()==id) return updateCas;
            else return c;}).collect(Collectors.toList());
        return updateCas;
    }
    public Car save(CarPojo pojo){
        Car customer =CarMapper.INSTANCE.pojoToCar(pojo);
        // xac định phần tử cuối của list
        Car lastCar = cars.get(cars.size() -1);
        //tạo thêm 1 phần tử nối tiếp
        var id =lastCar.getId() +1;
        customer.setId(id);
        cars.add(customer);
        return customer;
    }

    public Car create(Car car){
        int id;
        if (cars.isEmpty()) {
            id = 1;
        } else {
            Car lastCar = cars.get(cars.size() - 1);
            id = lastCar.getId() + 1;
        }
        car.setId(id);
        cars.add(car);
        return car;
    }
    public Car delete (Integer id){
        // tìm
        Optional<Car> car = cars.stream().filter(c->c.getId()==id).findFirst();
        if (car.isPresent()){
            cars.remove(car.get());
            return car.get();
        }
        return null;
    }
    public List<Car> sort(String direction){
        switch (direction){
            case "asc":
                return getAllCar()
                        .stream()
                        .sorted(Comparator.comparing(Car::getBrand))
                        .collect(Collectors.toList());
            case "desc":
                return getAllCar().stream().sorted(Comparator.comparing(Car::getBrand).reversed()).collect(Collectors.toList());
            default:
                return getAllCar();
        }
    }
}
