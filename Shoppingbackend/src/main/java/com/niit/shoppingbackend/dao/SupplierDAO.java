package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.domain.Supplier;

public interface SupplierDAO {

	public boolean save(Supplier supplier);

	public boolean update(Supplier supplier);

	public List<Supplier> list();

	public boolean delete(String id);

	public Supplier getSupplierById(String id);

	public Supplier getSupplierByName(String name);

}
