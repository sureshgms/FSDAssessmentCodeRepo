package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Productcategory;
import com.service.CategoryService;

@RestController
public class CategoryRestController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("getcategory")
	public List<Productcategory> getAllCategories() {
		return categoryService.findAllCategories();
	}

	@GetMapping("/getcategorybyId/{id}")
	public Optional<Productcategory> getcategorybyId(@PathVariable("id") int id) {
		return categoryService.findById(id);
	}

	@GetMapping("/getcategorybyName/{cname}")
	public Optional<Productcategory> getcategoryByName(@PathVariable("cname") String cname) {
		return categoryService.findByCategoryName(cname);
	}

/*	@PostMapping("/saveCategory")
	public String saveCategory(@RequestBody Productcategory pcat) {
		return categoryService.saveCategory(pcat);
	} */

}
