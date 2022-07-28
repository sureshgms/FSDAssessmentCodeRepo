package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Products;
import com.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	ProductService prodService;
	
	@RequestMapping(value="productDetails", produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	public List<Products> getAllProducts() {
		return prodService.findAllProducts();
	}
	
	/*@GetMapping("/getproductwithCategory")
	public List<CategoryProductList> getcatprodList() {
		return prodService.findProdwithCategory();
	}*/
	
	@GetMapping("/getproductbyId/{id}")
	public Optional<Products> getProductbyId(@PathVariable("id") int id) {
		return prodService.findByProductId(id);
	}
	
	@GetMapping("/getproductbyName/{pname}")
	public Optional<Products> getProductByName(@PathVariable("pname") String pname) {
		return prodService.findByProductName(pname);
	}
	
/*	@PostMapping("/saveProduct")
	public String saveProduct(@RequestBody Products prd) {
		return prodService.saveProduct(prd);
	} */
}
