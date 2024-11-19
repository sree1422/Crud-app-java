package com.crudApplication.service;

import java.util.List;

import com.crudApplication.model.Product;

public interface ProductService {
public List<Product> getAllProducts();
public Product getProduct(Integer id);
public Product saveProduct(Product product);
public boolean deleteProduct(Integer id);
}
