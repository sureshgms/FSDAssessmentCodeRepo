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
import com.dto.CategoryProductList;
import com.service.AdminService;
import com.service.CategoryService;
import com.service.ProductService;

@Controller
public class AdminLoginController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	CategoryService catService;
	
	@Autowired
	ProductService prodService;
	
	@RequestMapping(value="checkAdminLogin" , method=RequestMethod.POST)
	public String checkAdminLogin(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String username = req.getParameter("email");
		String password = req.getParameter("password");
		
		List<Productcategory> catList = catService.findAllCategories();
		List<Products> prodList = prodService.findAllProducts();
		
		session.setAttribute("curPwd", password);
		session.setAttribute("curUserName", username);
		session.setAttribute("catList", catList);
		session.setAttribute("prodList", prodList);
		
		if((adminService.getAdminByUserName(username, password)).isPresent()) {
			return "AdminLoginSuccess";
		} else {
			return "AdminLoginFailed";
		}
		
	}
	
	@RequestMapping(value="changePassword", method=RequestMethod.POST)
	public String changePassword(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String oldPassword = req.getParameter("oldpassword");
		String newPassword = req.getParameter("newpassword");
		String confirmPassword = req.getParameter("confirmpassword");
		String oldDbPwd = (String) session.getAttribute("curPwd");
		String username = (String) session.getAttribute("curUserName");
		
		if(!(newPassword.equals(confirmPassword) ) || !(oldDbPwd.equals(oldPassword))) {
			
			System.out.println("New password does not match Or Old password incorrect ..Please try again");
			return "pwdNotMatch";
		}
		else  {
			adminService.saveNewPassword(username, newPassword);
			return "pwdChanged";
		}
		
	}
	
}
