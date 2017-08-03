package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.domain.Category;
import com.niit.shoppingbackend.domain.Product;



@Controller
public class CategoryController {
	
	
	private static  Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	
	
	//create category
	//fetch all categories
	//delete category
	//update category
	
	@Autowired  CategoryDAO categoryDAO;
	
	@Autowired  Category category;
	
	@Autowired ProductDAO productDAO;
	
	@Autowired Product product;
	
	@Autowired  HttpSession session;
	
	
	
	@RequestMapping("/manage_category_add")
	public ModelAndView  createCategory(@RequestParam("id") String id, 
			@RequestParam("name") String name,  @RequestParam("description") String desc)
	{
		
		log.debug("Starting of the method manageCategories");
		category.setId(id);
		category.setName(name);
		category.setDescription(desc);
		
		ModelAndView mv = new ModelAndView("Home");
		
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");
		
		//Before calling save method, check whether the category id already exist in db or not
		
		//if it is does not exist, then only call save method
		
		if (categoryDAO.getcategorybyid(id) !=null)
		{
			//category already exist
			mv.addObject("message", "Category already exist with teh id " +id);
			return mv;
			
		}
		else  // actualy else is not required if return statement is there in if condition
		{
			categoryDAO.save(category);
			mv.addObject("message", "Category created successfuly ");
		}
		
		
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);
		
	
		
		log.debug("End of the method manageCategories");
		
		return mv;
		
		
		
	}
	
	
	
	
	
	
	
	@RequestMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id)
	{
		
		log.debug("Starting of the method deleteCategory");
		log.debug("You are going to delete " + id);
		ModelAndView mv = new ModelAndView("redirect:/manageCategories"); //This should be redirected to manage categories to display the updated content
		 
		// check weather products are there for this category or not
		//check whether products are there for this category or not
		int size = productDAO.getAllProductsByCategoryId(id).size();
		if(size!=0)
		{
			log.debug("Few products are there under this category. you can not delete");
			mv.addObject("message", size+ " products are there under category" + id +". you can not delete");
			session.setAttribute("message", size+ " products are there under category" + id +". you can not delete");
			return mv;
		}
		
		/*if(productDAO.getAllProductsByCategoryId(id).size()!=0)
		{
			mv.addObject("message","Few Products are there under this category you cannot delete");
			return mv;
		  }*/
		
		if( categoryDAO.delete(id))
		 {
			 mv.addObject("message", "successfully deleted the category");
		 }
		 else
		 {
			 mv.addObject("message", "Not able to delte the category");
		 }
		 
			session.setAttribute("categoryList", categoryDAO.list());
			session.setAttribute("category", category);
			
		
			log.debug("Ending of the method deleteCategory");
		 
		 return mv;
		
	}	

	//Edit category
	//You did wrong here
	@RequestMapping("/manage_category_edit/{id}")
	public ModelAndView editCategory(@PathVariable("id") String id){
		log.debug("Starting of editCategory");
		log.info("You are about to edit a category with id : " + id);
		
		category = categoryDAO.getcategorybyid(id);
		
		//Selected category details we have to store in another instance
		//i.e., ModelAndView instance
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		mv.addObject("selectedCategory", category);	
		session.setAttribute("selectedCategory", category);	
		
		log.debug("Ending of editCategory");

		return mv;
	}
	
	@PostMapping("/manage_category_update")
	public ModelAndView updateCategory(@RequestParam("cId") String id, @RequestParam("cName") String name,
			@RequestParam("cDescription") String description) {
		log.debug("Starting of updateCategory");
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");

		category.setId(id);
		category.setName(name);
		category.setDescription(description);

		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");

		if (categoryDAO.getcategorybyid(id) == null) {
			mv.addObject("message", "Category does not exists with id : " + id);
			return mv;
		} else {
			categoryDAO.update(category);
			mv.addObject("message", "Category updated success with id : " + id); //here model and view is unable to carry message. hence we will add session.
			session.setAttribute("message", "Category updated success with id : " + id);
			// You spelled mv wrong here.. Hence message is not being displayed!
			//mv.addObject("message", "Category updated success with id : " + id);
			

		}


		// Before calling save method, check whether category_id already exists
		// in db
		// if it does not exist, then only call save method.
		log.debug("Ending of updateCategory");
		return mv;
	}

}
