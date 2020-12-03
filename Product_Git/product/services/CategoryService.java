package com.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Category;
import com.product.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository catRepo;
	
	public List<Category> getCatList(){
		
		List<Category> list = catRepo.findAll();
		
		return list;
	}
	
	public String addCate(Category cate) {
		
		Category result = catRepo.save(cate);
		
		if(result!=null)
			return "Category Added";
		else
			return "Not Added";
	}
	
	public Category getCate(int cat_id) {
		
		Optional<Category> op = catRepo.findById(cat_id);
		
		Category cat = op.get();
		
		return cat;
	}
	
}
