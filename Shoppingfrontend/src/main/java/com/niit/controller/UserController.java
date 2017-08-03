package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.domain.Category;
import com.niit.shoppingbackend.domain.Product;
import com.niit.shoppingbackend.domain.Supplier;
import com.niit.shoppingbackend.domain.User;


@Controller
public class UserController {
	@Autowired
	UserDAO userDAO;
	@Autowired
	User user;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;

	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;

	@Autowired
	Product product;
	@Autowired
	ProductDAO productDAO;

	@Autowired
	HttpSession session;

	@PostMapping("validate")
	public ModelAndView login(@RequestParam("userName") String id, @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView("/Home");
		if (userDAO.validate(id, password) == true)

		{
			user = userDAO.get(id);
			mv.addObject("message", "Welcome" + user.getName());
			mv.addObject("categoryList", categoryDAO.list());
			mv.addObject("category", category);
			// store id in session
			session.setAttribute("LoggedInUserID", id);
			mv.addObject("supplierList", supplierDAO.list());
			mv.addObject("supplier", supplier);

			mv.addObject("productList", productDAO.list());
			mv.addObject("product", product);

			if (user.getRole().equals("ROLE_ADMIN")) {

				mv.addObject("isAdmin", true);
				session.setAttribute("role", "ROLE_ADMIN");
			} else {
				mv.addObject("isAdmin", false);
				session.setAttribute("role", "ROLE_USER");

			}

		} else {
			mv.addObject("message", "Invalid credentials..please try again");
		}

		return mv;
	}

	@RequestMapping("/Register")
	public ModelAndView register(@RequestParam("uId") String id, @RequestParam("uPassword") String password, @RequestParam("uName") String name, @RequestParam("uContact") String contact) {

		ModelAndView mv = new ModelAndView("/Home");
		/*log.debug("Starting of the method register");
		log.debug("Assigning values");*/
		
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setContact(contact);
		user.setRole("ROLE_USER");
		
		
		/*log.info("You are signing up with username : "+id);*/
		
		if (userDAO.save(user) == true) {
			/*log.debug("saving credentials");*/
			user = userDAO.get(id);
			mv.addObject("message", "Welcome " + user.getName() + "! Please Login to Continue");

			mv.addObject("categoryList", categoryDAO.list());
			mv.addObject("category", categoryDAO);

			mv.addObject("supplierList", supplierDAO.list());
			mv.addObject("supplier", supplierDAO);
			

			
		} else {
			/*log.debug("Error");*/
			mv.addObject("message", "invalid credentials");
		}
		/*log.debug("Ending of the method login");*/
		return mv;

	}

}
