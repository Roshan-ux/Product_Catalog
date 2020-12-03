package com.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Attribute_Master;
import com.product.repository.Attribute_Master_Repo;

@Service
public class AttributeService {

	@Autowired
	Attribute_Master_Repo att_Repo;
	
	public String addAttribute(Attribute_Master attr) {
		
		Attribute_Master attribute = att_Repo.save(attr);
		
		if(attribute!=null)
			return "Attribute Added";
		else
			return "Not Added";
	}
	
	public Attribute_Master getAttribute(int att_id) {
		
		Optional<Attribute_Master> op = att_Repo.findById(att_id);
		
		Attribute_Master att = op.get();
		
		return att;
	}
	
	public List<Attribute_Master> getAttributeList(){
		
		List<Attribute_Master> list = att_Repo.findAll();
		
		return list;
	}
}
