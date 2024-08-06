package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	@Autowired
	private ProductService productService;

//	public ProductController(ProductService productService) {
//		
//		this.productService = productService;
//	}
//	
//	@GetMapping("/search")
//public ResponseEntity<List<Product>> searchProducts(@RequestParam("query")String query){
//	return ResponseEntity.ok(productService.searchProducts(query));
//	
//}
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product product) {
	    try {
	        Product updatedProduct = productService.updateProduct(id, product);
	        return ResponseEntity.ok("Product updated successfully: " + updatedProduct.getName());
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    }
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteproduct(@PathVariable Long id){
		try {
		productService.deleteProduct(id);
		return ResponseEntity.ok("product deleted with id"+id);
	}
		
	catch(RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		
	}
	}
}

	
	
//	@GetMapping("/search")
//	public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") )
	
//	@GetMapping("/{id}")
//	public ResponseEntity<Product> getproductById(@PathVariable Long id){
//		return ResponseEntity.ok(productService.getProductById(id));
		
		
		
	
	

