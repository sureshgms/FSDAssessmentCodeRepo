package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.CategoryRepository;
import com.bean.Productcategory;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	

	public List<Productcategory> findAllCategories() {
		return categoryRepository.findAll();
	}

	public Optional<Productcategory> findById(int catId) {
		return categoryRepository.findById(catId);
	}

	public Optional<Productcategory> findByCategoryName(String catName) {
		return categoryRepository.findByCategoryname(catName);
	}

	public String saveCategory(String cname) {
		
		
		Productcategory pc = new Productcategory();

		Optional<Productcategory> pcat = categoryRepository.findByCategoryname(cname);

		if (pcat.isPresent()) {
			return "Duplicate Category";
		} else {
			pc.setCategoryname(cname);
		//	pc.setCategoryid(0);

			categoryRepository.save(pc);
			return "Category Saved";
		}
	}

}
