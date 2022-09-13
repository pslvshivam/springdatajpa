package com.ust.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.springboot.data.entities.Product;
import com.ust.springboot.data.repos.ProductRepository;

@RestController
@RequestMapping("/products")  
public class ProductController {
	
	@Autowired
	ProductRepository repository;
	
	@GetMapping// for reading
	public Iterable<Product> getProducts()
	{
		return repository.findAll();// select * from product;
	}
	
	@PostMapping// for posting
	public Product create(@RequestBody Product product)
	{
		return repository.save(product); // create a row in the database table(product table)
	}
	
	@PutMapping // updation
	public Product update(@RequestBody Product product)
	{
		return repository.save(product);// it creates a row if not there, if the product is existing, then it will just update the details
	}
	
	@GetMapping("/{id}")// getting a particular product with its id
	public Product getProduct(@PathVariable Long id)
	{
		Optional<Product> p=repository.findById(id);// select * from products where id=?;
		Product prod=p.get();
		return prod;
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id)
	{
		repository.deleteById(id);
	}
	
	@GetMapping("{name}/{price}")
	public Iterable<Product> getNameAndPrice(@PathVariable String name,@PathVariable Double price)
	{
		return repository.findByNameAndPrice(name,price);
	}
	
	@GetMapping("{price}/price/{price2}")
	public Iterable<Product> getPriceBetween(@PathVariable Double price,@PathVariable Double price2)
	{
		return repository.findByPriceBetween(price,price2);
	}
	
	@GetMapping("/nameandid/{name}/{id}")
	public Iterable<Product> getNameAndId(@PathVariable String name,@PathVariable Long id)
	{
		return repository.findByNameAndId(name, id);
	}
	
	@GetMapping("/findbyname/{name}")
	public Iterable<Product> getName(@PathVariable String name)
	{
		return repository.findByName(name);
	}
	
	@GetMapping("/findbyprice/{price}")
	public Iterable<Product> getPrice(@PathVariable Double price)
	{
		return repository.findByPrice(price);
	}
	
	
}
