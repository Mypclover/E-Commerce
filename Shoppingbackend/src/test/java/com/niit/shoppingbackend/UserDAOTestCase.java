package com.niit.shoppingbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.domain.User;

public class UserDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static UserDAO userDAO;

	@Autowired
	static User user;

	// above object need to initialize
	// This is method going execute before calling any one of test case and will
	// execute only once
	@BeforeClass
	public static void initialize() {

		context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.*");
		context.refresh();
		// get userDAO from context
		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
	}

	@Test
	public void createUserTestCase(){
		
		user.setId("naveenk");
		user.setName("naveen");
		user.setPassword("naveen");
		user.setRole("Role_User");
		user.setContact("1234567890");
		
		boolean flag = userDAO.save(user);
		
		// assetEquals method
		// error 	- if their is in runtime errors -Red mark
		// Success	- if excepted and actual is same -green mark
		// fail	-	- if excepted and actual is different -blue mark
		assertEquals("createUserTestCase", true, flag);
	}
	@Test
	public void updateUserTestCase(){

		user.setId("naveen");
		user.setName("naveen");
		user.setPassword("naveen");
		user.setRole("Admin_User");
		user.setContact("1234567890");
		
		boolean flag = userDAO.update(user);
		assertEquals("updateUserTestCase", true, flag);
	}
	
	@Test
	public void validateUserTestCase(){
		
		
		
		boolean flag=userDAO.validate("naveen","naveen");
		
		assertEquals(true,flag);
	}
	
	@Test
	public void getAllUserTestCase()
	{
		int actualSize=   userDAO.list().size();
		
		//will compare actual and expected
		//if actual and expected is same - TC will pass
		//if it is different - TC fail
		assertEquals(4, actualSize);
	}
}




