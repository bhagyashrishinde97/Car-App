package com.bamossza.project.controller;

import java.util.*;

import com.bamossza.project.entities.EmployeeTest;
import com.bamossza.project.repository.EmployeeTestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.bamossza.project.entities.Car;
import com.bamossza.project.service.CarService;

@RestController
@RequestMapping(value = "/api/cars")
public class CarController {

	private static final Logger logger = LoggerFactory.getLogger(CarController.class);

	@Autowired
	private CarService carService;

	@Autowired
    private EmployeeTestRepository employeeTestRepository;

	@Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
	
	@RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity<Void> createCar(@RequestBody Car car) {
        try {
        	logger.info(car.getCarBrand());
        	logger.info(car.getCarEngine());
        	logger.info(car.getCarModel());
        	logger.info(car.getHorsepower());
            carService.add(car);
            //carService.add(car);
            logger.error("");
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ArithmeticException ae){
            logger.error("Error occurred while trying to create car");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, Object>>> getAll() {
        try {
        	List<Map<String, Object>> result = carService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Car> getCarByIdTest(@PathVariable(value = "id", required = false) Integer id) {
        try {
            if(id == 0){
                return ResponseEntity.status(HttpStatus.OK).body(new Car());
            }
            Car car = carService.findById(id);
            // car.getCarId();
            if (car != null) {
                return ResponseEntity.status(HttpStatus.OK).body(car);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<Car> getCarByIdTest3333(@RequestParam(required = true, defaultValue = "0") Integer id,
                                                  @RequestParam(required = false, defaultValue = "0") Integer id1) {
        try {
            if(id == 0){
                return ResponseEntity.status(HttpStatus.OK).body(new Car());
            }

            Car car = carService.findById(id);
            // car.getCarId();
            if (car != null) {
                return ResponseEntity.status(HttpStatus.OK).body(car);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/dummy/{id}", method = RequestMethod.GET, produces = "application/json", consumes = "application/xml")
    public ResponseEntity<Car> getCarByIdDummy(@PathVariable("id") Integer id) {
        try {
            Car car = carService.findById(id);
            // car.getCarId();
            if (car != null) {
                return ResponseEntity.status(HttpStatus.OK).body(car);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Car> getCarById(@PathVariable("id") int id) {
        try {
            Car car = carService.findById(id);
           // car.getCarId();
            if (car != null) {
                return ResponseEntity.status(HttpStatus.OK).body(car);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<Car> getCarByModel(@RequestParam(required = false) String model) {
        try {
            Car car = carService.findCarByModel(model);
            // car.getCarId();
            if (car != null) {
                return (ResponseEntity<Car>) ResponseEntity.status(HttpStatus.OK).body(car);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @RequestMapping(value = "/test123123", method = RequestMethod.GET)
    public ResponseEntity<Car> getCarByModel12345(@RequestParam(required = false) String model) {
        try {
            Car car = carService.findCarByModel(model);
            // car.getCarId();
            if (car != null) {
                return (ResponseEntity<Car>) ResponseEntity.status(HttpStatus.OK).body(car);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Car car) {
        try {
            carService.update(id, car);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        try {
            carService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, Object>>> getAllEmps(@RequestBody Car car) {
        try {
            List<Map<String, Object>> result = carService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/employeetest", method = RequestMethod.POST)
    public ResponseEntity<Void> createEmp(@RequestBody EmployeeTest employeeTest) {
        try {
            employeeTestRepository.save(employeeTest);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
