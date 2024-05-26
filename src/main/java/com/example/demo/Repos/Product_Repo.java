package com.example.demo.Repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Product;

public interface Product_Repo extends JpaRepository<Product,Integer> {
	 List<Product> findByProductName(String productName);
}
