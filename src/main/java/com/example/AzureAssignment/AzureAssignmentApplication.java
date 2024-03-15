package com.example.AzureAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class AzureAssignmentApplication {

	@Autowired
	private ProductInterface productInterface;

	public static void main(String[] args) {
		SpringApplication.run(AzureAssignmentApplication.class, args);

		System.out.println("hello im here");
	}

	@CrossOrigin(origins = "http://localhost:3000/")
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody  Product product){
		return  productInterface.save(product);
	}

	@CrossOrigin(origins = "http://localhost:3000/")
	@GetMapping ("/getAllProducts")
	List<Product> getAllProducts(){
		return productInterface.findAll();
	}
}
