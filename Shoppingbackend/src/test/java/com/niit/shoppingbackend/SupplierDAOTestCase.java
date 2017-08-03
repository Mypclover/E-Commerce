package com.niit.shoppingbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.domain.Supplier;

public class SupplierDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static SupplierDAO supplierDAO;
	@Autowired
	static Supplier supplier;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the categoryDAO from context
		supplierDAO =  (SupplierDAO) context.getBean("supplierDAO");
		
		//get the category from context
		
		supplier = (Supplier)context.getBean("supplier");
		
	}
	
	//@Test
	public void createSupplierTestCase()
	{
		supplier.setId("RockStars");
		supplier.setName("Grand Thef Autp");
		supplier.setAddress("Chennai");
		supplier.setDescription("Yop Open World Games");
		
		boolean flag =  supplierDAO.save(supplier);
		
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createSupplierTestCase",true,flag);
		
	}
	@Test
	public void updateSupplierTestCase()
	{
		supplier.setId("RockStars");
		supplier.setName("Grand Thef Auto");
		supplier.setAddress("Chennai");
		supplier.setDescription("Top Open World Games");
		
		boolean flag =  supplierDAO.update(supplier);
		
		
		
		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("updateSupplierTestCase",true,flag);
		
	}
	
	@Test
	public void listAllSupplierTestCase()
	{
		int actualSize = supplierDAO.list().size();
		assertEquals(2, actualSize);
	} 
	
	
}
