package com.niit.shoppingbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {

	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");//scan this package and find out where the annotations 
									//@component
		context.refresh();
		
		// if you need any instance, do not create
		// You can ask context to get a particular bean getBean()
		
		context.getBean("category");  // Bean name same as the class name but 
							//first character will be lower case
					
		System.out.println("The instances is created successfully");
 	}
}