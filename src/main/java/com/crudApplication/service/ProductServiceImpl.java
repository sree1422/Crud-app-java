package com.crudApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudApplication.model.Product;
import com.crudApplication.repository.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService{
@Autowired
private ProductRepo repo;
@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}
@Override
	public Product saveProduct(Product product) {
		
		return repo.save(product);
	}
@Override
public Product getProduct(Integer id) {
	return repo.findById(id).get();
}
@Override
public boolean deleteProduct(Integer id) {
	boolean status=repo.findById(id).isPresent() ;
	repo.deleteById(id);
	return status;
	
}
}
