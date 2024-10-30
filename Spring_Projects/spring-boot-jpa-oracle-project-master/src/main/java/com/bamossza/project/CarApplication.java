package com.bamossza.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CarApplication {

	public static void main(String[] args) {

		SpringApplication.run(CarApplication.class, args);
		System.out.println("Application Started!!!!");
		/*ApplicationContext ctx = SpringApplication.run(CarApplication.class, args);
		String[] allBeanNames = ctx.getBeanDefinitionNames();
		for(String beanName : allBeanNames) {
			System.out.println(beanName);
		}*/

	}
}
