package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
//	List<Product> searchProducts(String query);

	Product createProduct(Product product);
	
	Product updateProduct(Long id, Product product);
	
	void deleteProduct(Long id);

	//Product getProductById(Long id);

	

}
