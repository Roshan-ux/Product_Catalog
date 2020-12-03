package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.model.Attribute_Master;

@Repository
public interface Attribute_Master_Repo extends JpaRepository<Attribute_Master, Integer>{

}
