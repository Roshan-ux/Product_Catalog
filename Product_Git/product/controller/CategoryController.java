package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Category;
import com.product.services.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService cateService;
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getList(){
		
		List<Category> cat = cateService.getCatList();
		
		return ResponseEntity.of(Optional.of(cat));
	}
	
	@PostMapping("/addcategory")
	public ResponseEntity<String> addCategory(@RequestBody Category cate){
		
		String msg = cateService.addCate(cate);
		
		return ResponseEntity.of(Optional.of(msg));
	}
	
	@GetMapping("/getcategory")
	public ResponseEntity<Category> getCategory(int cat_id){
		
		Category cate = cateService.getCate(cat_id);
		
		return ResponseEntity.of(Optional.of(cate));
	}
}
