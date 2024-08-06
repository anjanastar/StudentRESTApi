package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
//	@Query("SELECT p from Product p WHERE "+"p.name LIKE CONCAT('%',:query,'%')"+
//	"Or p.description LIKE CONCAT('%',:query,'%')")
//	List<Product> searchProducts(String query);

}
