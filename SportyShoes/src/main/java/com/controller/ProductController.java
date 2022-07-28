package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Productcategory;
import com.bean.Products;
import com.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService pService;
	
	@RequestMapping(value="saveProduct", method=RequestMethod.POST)
	public String saveNewProduct(HttpServletRequest req ) {
		
		HttpSession session = req.getSession();
		String pName = req.getParameter("productname");
		int pCategory = Integer.parseInt(req.getParameter("pCategory"));
		
		Products p = new Products();
		Productcategory pc = new Productcategory();
		
		p.setProductname(pName);
		pc.setCategoryid(pCategory);
		
		p.setPcategory(pc);
		
		pService.saveProduct(p);
		
		//Populate session attribute again with new Product
		//ProductService ps1 = new ProductService();
		List<Products> prodList = pService.findAllProducts();
		session.setAttribute("prodList", prodList);
		
		return "productSaved";
	}

}
