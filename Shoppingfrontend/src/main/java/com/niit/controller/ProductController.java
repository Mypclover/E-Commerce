package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.domain.Category;
import com.niit.shoppingbackend.domain.Product;
import com.niit.shoppingbackend.domain.Supplier;
import com.niit.util.FileUtil;





@Controller
public class ProductController {
	
	private static Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired HttpSession session;
	
	@Autowired Product product;
	
	@Autowired ProductDAO productDAO;
	
	@Autowired Category category;
	
	@Autowired CategoryDAO categoryDAO;
	
	@Autowired Supplier supplier;
	
	@Autowired SupplierDAO supplierDAO;
	
	
		//Actually we have to keep this path in a property file
		//private String path = "G:\MyProject\ShoppingCartFrontEnd\src\main\webapp\resources\images";
		
		//private String path = "resources/imges/";
	
	// setting path to store images
	 // private String path   ="G://MyProject//ShoppingCartFrontEnd//src//main/webapp//resources//images";
	  private String path   = "D://Project NIIT//Testing//Shoppingfrontend//src//main//webapp//resources//images";
		
	  // get the path where you downloaded tomcat
	  //E:\Software\Tomcat\apache-tomcat-9.0.0.M18-windows-x64
	  //private  String path =System.getProperty("catalina.home");
	  
	 /*@RequestMapping("/searchProduct/{search_string}")
		public ModelAndView getAllProductBySearchString(@PathVariable("search_string")
			String search_string)
		{
		  List<Product> products=	 productDAO.getSimilarProducts(search_string);
		  ModelAndView mv= new ModelAndView("/Home");
		  
		  if(products.isEmpty())
		  {
			  mv.addObject("msg", "No products are available with the search text :" +search_string );
		  }
		  else
		  {
			  mv.addObject("productList", products);
		  }
	  
		  return mv;
	  
		}*/
	
	  @RequestMapping(value = "/manageProducts", method = RequestMethod.GET)
		public String listProducts(Model model) {
			log.debug("Starting of the method listProducts");
			
			model.addAttribute("isAdminClickedProducts", "true");
			model.addAttribute("isAdmin","true");
			
			model.addAttribute("product", product);
			model.addAttribute("productList", productDAO.list());
			model.addAttribute("category",category);
			model.addAttribute("categoryList",categoryDAO.list());
			model.addAttribute("supplier",supplier);
			model.addAttribute("supplierList",supplierDAO.list());
			
			log.debug("Ending of the method listProducts");
			
			return "Home";
		}
	  
	 
	  
	  
	  
	  // For add and Update Product Both
	  
	  @RequestMapping(value="/manage_product_add", method=RequestMethod.POST)
	  public String addProduct(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile file, Model model)
	  {
		  log.debug("Starting of method addProduct");
		  
		  Category category = categoryDAO.getcategorybyid(product.getCategory().getName());
		  
		  Supplier supplier = supplierDAO.getSupplierById(product.getSupplier().getName());
		  
		  
		  product.setCategory(category);
		  product.setSupplier(supplier);
		  
		  product.setCategory_id(category.getId());
		  product.setSupplier_id(supplier.getId());
		  
		  FileUtil.upload(path, file, product.getId() + ".jpg");
		  
		  
		
			  // create  new the product
			  productDAO.save(product);
		  
		  
		  
			  // update the product
			  productDAO.update(product);
		  
		  
		  
		  model.addAttribute("isAdminClickedProducts","true");
		  model.addAttribute("isAdmin","true");
		  
		  model.addAttribute("productList",productDAO.list());
		  model.addAttribute("product",product);
		  
		  model.addAttribute("categoryList",categoryDAO.list());
		  model.addAttribute("category",category);
		  
		  model.addAttribute("supplierList",supplierDAO.list());
		  model.addAttribute("supplier",supplier);
		  
		  log.debug("Ending of method add Product");
		  
		  return "Home";
		  
	  }
	  
	  // update the product
	/*  @RequestMapping(value="manage_product_update", method=RequestMethod.POST)
	  public String updateProduct(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile file, Model model)
	  {
		  log.debug("Starting of the method update Product");
		  Category category = categoryDAO.getCategoryById(product.getCategory().getName());
		  
		  Supplier supplier = supplierDAO.getSupplierById(product.getSupplier().getName());
		  
		  
		  product.setCategory(category);
		  product.setSupplier(supplier);
		  
		  product.setCategory_id(category.getId());
		  product.setSupplier_id(supplier.getId());
		  
		  FileUtil.upload(path, file, product.getId() + ".jpg");
		  
		  productDAO.update(product);
		  
		  return "Home";
	  }*/

	  // Delete Product
	  @RequestMapping("/manage_product_delete/{id}")
	  public String deleteProduct(@PathVariable("id") String id,ModelMap model)
	  {
		  log.debug("Starting of the method deleteProduct");
		  
		  try
		  {
			  productDAO.delete(id);
			  model.addAttribute("message","Successfully Deleted Product");
		  }
		  catch (Exception e) {
			model.addAttribute("message",e.getMessage());
			e.printStackTrace();
		}
		  
		  log.debug("Ending of the Method deleteProduct");
		  
		  return "redirect:/manageProducts";
	  }
	
	  // Edit Product
	  
	  @RequestMapping("/manage_product_edit/{id}")
	  
	  public ModelAndView editProduct(@PathVariable("id") String id)
	  {
		  log.debug("Starting of the method Edit Product");
		  
		  log.debug("Going to Edit the Product: "+id);
		  
		  ModelAndView mv = new ModelAndView("redirect:/manageProducts");
		  mv.addObject("isAdminClickedProducts","true");
		  mv.addObject("isAdmin","true");
		  product = productDAO.getProductById(id);
		  
		  mv.addObject("product",product);
		  return mv;
	  }
	
	  // get selected product
	  
	  @RequestMapping("/manage_product_get/{id}")
	  public ModelAndView getSelectedProduct(@PathVariable("id") String id, RedirectAttributes redirectAttributes)
	  {
		  
		  log.debug("Starting of method getSelectedProduct");
		  
		  ModelAndView mv =  new ModelAndView("redirect:/");
		   
		  redirectAttributes.addFlashAttribute("selectedProduct",productDAO.getProductById(id));
		  
		  log.debug("Ending of the method getSelectedproduct");
		  
		  return mv;
	  }
	  
	  @RequestMapping("/viewProduct")
		public String viewProductHome(Model model) {
			model.addAttribute("isUserSelectedProduct", "true");
			return "Home";
			
		}
		
		@RequestMapping("/viewProduct/{id}")
		public String viewProduct(@PathVariable("id") String id, Model model) {
			session.setAttribute("selectedProduct", productDAO.getProductById(id));
			return "redirect:/viewProduct";
		}
		
		@RequestMapping("/showProductByCategory/{category_id}")
		public String showProductByCategory(@PathVariable("category_id") String category_id, Model model){
				session.setAttribute("selectedCategoryProducts", productDAO.getAllProductsByCategoryId(category_id));
				session.setAttribute("product",product);
				model.addAttribute("isUserClickedProductByCategory", "true");
			return "redirect:/productByCategory";
		}
		
		@RequestMapping("/productByCategory")
		public String productByCategory(Model model){
			model.addAttribute("isUserClickedProductByCategory", "true");
			return "Home";

		}
	
}




