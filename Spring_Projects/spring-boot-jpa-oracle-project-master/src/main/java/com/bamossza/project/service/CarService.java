package com.bamossza.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bamossza.project.impl.CarDao;
import com.bamossza.project.entities.Car;

@Controller
@Transactional
public class CarService {

    @Autowired
    private CarDao carDao;

    public CarService() {

    }

    public Car findById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID cannot be 0 or < 0");
        }
        return carDao.findById(id);
    }

    public Car findCarByModel(String model) {

        return carDao.findCarByModel(model);
    }

    public void remove(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID cannot be 0 or < 0 or this id do not exist");
        }
        carDao.remove(id);
    }

    public List<Map<String, Object>> findAll() {

        List<Map<String, Object>> result = carDao.findAll();
        if (!result.isEmpty()) {
            return result;
        }
        return null;
    }

    public void add(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("The passed object cannot be null.");
        }
        carDao.add(car);
    }

    public void update(int id, Car car) {
        if (id <= 0 && car == null) {
            throw new IllegalArgumentException("The passed object cannot be null.");
        }
        carDao.update(id, car);
    }

   /* public EmployeeTest findByTestEmailId(String emailId){
        return carDao.findByTestEmailId(emailId);
    }*/

}
