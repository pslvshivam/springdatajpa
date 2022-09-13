package com.ust.springboot.data.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ust.springboot.data.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByName(String name);// select * from product where name="?";

	List<Product> findByPrice(Double price);
	
	List<Product> findByNameAndPrice(String name, Double price);
	
	List<Product> findByNameAndId(String name, Long id);
	
	List<Product> findByPriceBetween(Double price, Double price2);
	

	

}
