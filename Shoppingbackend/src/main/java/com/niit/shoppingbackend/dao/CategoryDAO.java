package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.domain.Category;


public interface CategoryDAO
{
	public List<Category> list();
	public boolean save(Category category);
	public boolean update(Category category);
	public boolean delete(String id);
	public Category getcategorybyid(String id);
	public Category getcategorybyname(String name);
	
	
}
