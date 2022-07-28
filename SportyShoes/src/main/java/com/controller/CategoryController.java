package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Productcategory;
import com.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService catService;
	
	//@Autowired
	//Productcategory pcat1;
	
	@RequestMapping(value="saveCategory", method=RequestMethod.POST)
	public String savenewCategory(HttpServletRequest req) {
		
		String catName = req.getParameter("categoryname");
		HttpSession session = req.getSession();
		
		//pcat1.setCategoryname(catName);
		
		if(catService.saveCategory(catName).equals("Category Saved")) {
			List<Productcategory> catList = catService.findAllCategories();
			session.setAttribute("catList", catList);
			return "CategorySaveSuccess";
		} else {
			return "CategoryNotSaved";
		}
		
	}

}
