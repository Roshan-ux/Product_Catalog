package com.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.model.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public List<Product> productList(){
		
		List<Product> list = productRepo.findAll();
		return list;
	}
	
	public String insertProd(Product prod) {
		
		Product result = productRepo.save(prod);
		if(result!=null)
			return "Product Added";
		else
			return "Product Not Added"; 
	}
	
	public Product productInfo(int prod_id) {
		
		Optional<Product> op = productRepo.findById(prod_id);
		Product prod = op.get();
		
		if(prod!=null)
			return prod;
		else
			return null;
	}
	
	public String update(String prod) {
		
		Product pro;
		try {
			pro = new ObjectMapper().readValue(prod, Product.class);
	
		Product result = productRepo.save(pro);
		if(result!=null)
			return "Product Updated";
		 
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return "Product Not Updated";
	}
	
	public String delete(int prod_id) {
		
		productRepo.deleteById(prod_id);
		return "Deleted";
	}

}
