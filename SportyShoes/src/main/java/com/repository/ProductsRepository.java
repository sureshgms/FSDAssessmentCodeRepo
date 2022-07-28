package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Products;



@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer>{
	

	public Optional<Products> findByProductname(String productname);

}
