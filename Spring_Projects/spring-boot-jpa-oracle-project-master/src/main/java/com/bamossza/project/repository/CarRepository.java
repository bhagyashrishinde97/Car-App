package com.bamossza.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bamossza.project.entities.Car;

//@Transactional(readOnly = true)
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

	//@Transactional(timeout = 10)
	Car findByCarId(Integer carId);
	//select * from Car where carId = '100';

	Car findByCarModel(String model);
	//@Transactional(timeout = 10)
	/*@Query
	List<Car> findAll();*/

	//List<Car> findByCarBrand(String carBrand);
	Optional<List<Car>> findByCarBrand(String carBrand);
	
	/*@Transactional
	<S extends Car> S saveCar(Car car);*/

	//void delete(Car car);
}
