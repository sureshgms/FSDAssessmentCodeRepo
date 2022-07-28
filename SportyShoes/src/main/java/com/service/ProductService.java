package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bean.Products;
import com.repository.ProductsRepository;

@Service
public class ProductService {

	@Autowired
	ProductsRepository productRepo;
	
//	@Autowired
	//ProductCategoryRepository productcatRepo;
	
	public List<Products> findAllProducts() {
		return productRepo.findAll();
	}

	public Optional<Products> findByProductId(int pid) {
		return productRepo.findById(pid);
	}
	
	public Optional<Products> findByProductName(String pName) {
		return productRepo.findByProductname(pName);
	}
	
	public String saveProduct(Products p) {
		Optional <Products> p1 = productRepo.findById(p.getProductid());
		
		if(p1.isPresent()) {
			return "Duplicate product";
		} else {
			productRepo.saveAndFlush(p);
			return "Product Saved";
		}
	}
}
