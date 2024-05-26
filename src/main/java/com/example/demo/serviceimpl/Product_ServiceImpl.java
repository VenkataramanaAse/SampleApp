package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Entity.Product;
import com.example.demo.Repos.Product_Repo;
import com.example.demo.Service.Product_Service;
@Service
public class Product_ServiceImpl implements Product_Service {
	       @Autowired
	       private Product_Repo product_Repo;
	
	public Product saveProduct(Product product) {
		return product_Repo.save(product);
	}
	public List<Product> get_Product()
	{
		return product_Repo.findAll();
	}
	
	 public void deleteProduct(Integer productId) {
         product_Repo.deleteById(productId);
     }
	 
	 public Product getProduct(Integer productId) {
	        Optional<Product> optionalProduct = product_Repo.findById(productId);
	        return optionalProduct.orElse(null); // You can return null or handle it differently based on your requirements
	    }
	 
	 public List<Product> getProductsByName(String productName) {
	        return product_Repo.findByProductName(productName);
	    }
}
