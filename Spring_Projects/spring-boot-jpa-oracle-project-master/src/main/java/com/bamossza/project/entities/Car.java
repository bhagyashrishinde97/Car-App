package com.bamossza.project.entities;

import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
//Employee_Department
@JsonIgnoreProperties(ignoreUnknown=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {
	//FROM Car                        HQL
	//Select * from CAR_DEC_2023      SQL
	//converts HQL into SQL   using Dialect
	private static final long serialVersionUID = 1L;
	public static final Logger logger = LoggerFactory.getLogger(Car.class);
	//insert script             21
	//through application    => 20  21
	
	@Id
	@GeneratedValue(generator = "CAR_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "CAR_SEQ", sequenceName = "CAR_SEQ", allocationSize=50)
	@Column( unique=true, nullable=false, precision=10, scale=0)
	//@Getter @Setter
	private Integer carId;

	@Column(name="CAR_BRAND_DUMMY", nullable = true, length = 50)
	//@Getter @Setter
	private String carBrand;
	
	@Column(name="CAR_MODEL_DUMMY", nullable = true, length = 50)
	//@Getter @Setter
    private String carModel;
	
	@Column(name="HORSEPOWER_DUMMY", nullable = true, length = 6)
	//@Getter @Setter
    private String horsepower;
	
	@Column(name="CAR_ENGINE_DUMMY", nullable = true, length = 6)
	//@Getter @Setter
    private String carEngine;

	@Column(name="CAR_ENGINE_DEC_2023", nullable = true, length = 6)
	//@Getter @Setter
	private String carEngineDec;
	
	/*public Car(){}
	
    public Car(String carBrand, String carModel, String horsepower, String carEngine) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.horsepower = horsepower;
        this.carEngine = carEngine;
    }*/
}
