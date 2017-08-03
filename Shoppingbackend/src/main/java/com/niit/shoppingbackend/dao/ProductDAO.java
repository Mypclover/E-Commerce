package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.domain.Product;

public interface ProductDAO {

	public boolean save(Product product);

	public boolean update(Product product);

	// delete category
	public boolean delete(String id);

	public List<Product> list();

	public Product getProductById(String id);
	
	//get all products pertaining to particular category
	public List<Product> getAllProductsByCategoryId(String categoryId);
	public List<Product> getAllProductsBySupplierId(String supplierId);
	
	public Product getProductByName(String name);
	
}
