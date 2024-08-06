package com.example.demo.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductRepository;
import java.util.*;

//import javax.management.relation.RelationTypeNotFoundException;

import com.example.demo.model.Product;
import com.example.demo.Service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	
//	@Override
//	public List<Product> searchProducts(String query) {
//		// TODO Auto-generated method stub
//	List<Product>products=productRepository.searchProducts(query);
//	return products;
//	}
	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}


	@Override
	public Product updateProduct(Long id, Product product) {
		// TODO Auto-generated method stub
		Optional<Product> existingProduct=productRepository.findById(id);
		if(existingProduct.isPresent()) {
			Product updatedProduct=existingProduct.get();
			updatedProduct.setSku(product.getSku());
			updatedProduct.setName(product.getName());
			updatedProduct.setDescription(product.getDescription());
			updatedProduct.setImageUrl(product.getImageUrl());
			updatedProduct.setDateUpdated(product.getDateUpdated());
			return productRepository.save(updatedProduct);
		}
		else {
			
			throw new RuntimeException("product not found with id"+id);
		}
		
	}


	@Override
	public void deleteProduct(Long id) {
		if(productRepository.existsById(id)) {
			productRepository.deleteById(id);
			
		}
		else {
			
			throw new RuntimeException("product not found"+id);
		}
		// TODO Auto-generated method stub
		
	}


//	@Override
//	public Product getProductById(Long id) throws RelationTypeNotFoundException {
//		return productRepository.findById(id).orElseThrow(()->new RelationTypeNotFoundException("product not found with id"+id));
//		
		// TODO Auto-generated method stub
		
		
	}



//	public List<Product> searchproduct(String query) {
//		// TODO Auto-generated method stub
//		return productRepository.searchProducts(query);
//	}


