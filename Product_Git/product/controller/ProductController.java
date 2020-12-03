package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.services.CategoryService;
import com.product.services.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
	
	@Autowired
	ProductService prodService;
	
	@GetMapping("/getproducts")
	public ResponseEntity<List<Product>> getProducts(){
		
		
		return ResponseEntity.of(Optional.of(null));
	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		
		String msg = prodService.insertProd(product);
		
		return ResponseEntity.of(Optional.of(msg));
	}
	
	@GetMapping("/details/{id}")
	public ResponseEntity<Product> details(@PathVariable("id") int prod_id){
		
		Product prod = prodService.productInfo(prod_id);
		return ResponseEntity.of(Optional.of(prod));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable("id") int prod_id, @RequestParam String product){
		
		String msg = prodService.update(product);
		return ResponseEntity.of(Optional.of(msg));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int prod_id){
		
		String msg = prodService.delete(prod_id);
		return ResponseEntity.of(Optional.of(msg));
	}

}
