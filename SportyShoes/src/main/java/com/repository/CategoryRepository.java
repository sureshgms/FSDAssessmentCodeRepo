package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.bean.Productcategory;

@Repository
public interface CategoryRepository extends JpaRepository<Productcategory, Integer>{
	
	public Optional<Productcategory> findByCategoryname(String categoryname);
	
	
	

}
