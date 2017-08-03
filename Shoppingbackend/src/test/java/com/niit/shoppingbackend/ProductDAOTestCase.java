package com.niit.shoppingbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.domain.Product;



public class ProductDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static Product product;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the categoryDAO from context
		productDAO =  (ProductDAO) context.getBean("productDAO");
		
		//get the category from context
		product = (Product)context.getBean("product");
		
	}
	
	@Test
	public void createProductTestCase()
	{
		
		product.setId("Test");
		product.setName("test");
		product.setDiscription("test");
		product.setPrice(70000);
		product.setCategory_id("cat001");
		product.setSupplier_id("sup008");
		
		
		boolean flag =  productDAO.save(product);

		assertEquals("createProductTestCase",true,flag);
		
	}
	
	@Test
	public void listAllProductTestCase()
	{
		int actualSize = productDAO.list().size();
		assertEquals(2, actualSize);
	} 

}
