package com.product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Attribute_Master;
import com.product.services.AttributeService;

@RestController
@CrossOrigin(origins = "*")
public class AttributeController {

	@Autowired
	AttributeService attribute;
	
	@PostMapping("/addattribute")
	public ResponseEntity<String> addAtt(@RequestBody Attribute_Master attr){
		
		String msg = attribute.addAttribute(attr);
		
		return ResponseEntity.of(Optional.of(msg));
	}
	
	public ResponseEntity<Attribute_Master> getAtt(int att_id){
		
		Attribute_Master attr = attribute.getAttribute(att_id);
		
		return ResponseEntity.of(Optional.of(attr));
	}
	
	
}
