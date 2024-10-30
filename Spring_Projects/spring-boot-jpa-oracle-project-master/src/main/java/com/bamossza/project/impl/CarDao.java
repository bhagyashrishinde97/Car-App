package com.bamossza.project.impl;

import java.util.List;
import java.util.Map;

import com.bamossza.project.entities.Car;
import org.springframework.stereotype.Component;

@Component
public interface CarDao {

    public Car findById(int id);

    public void remove(int id);

    public void add(Car car);

    public void update(int id, Car car);

    public List<Map<String, Object>> findAll();

    Car findCarByModel(String model);

    // public EmployeeTest findByTestEmailId(String emailId);
}
