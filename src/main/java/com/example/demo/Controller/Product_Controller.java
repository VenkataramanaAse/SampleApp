package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;
import com.example.demo.Service.Product_Service;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("Product")
@RestController
@CrossOrigin("*")
@Slf4j
public class Product_Controller {

	@Autowired
	private Product_Service product_Service;
	
	@PostMapping
	public ResponseEntity<Product> product( @Valid @RequestBody Product product){
		return ResponseEntity.ok(product_Service.saveProduct(product));
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> get_products(){
		return ResponseEntity.ok(product_Service.get_Product());
	}
	
	 @DeleteMapping("/product/{productId}")
	    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
	        product_Service.deleteProduct(productId);
	        return new ResponseEntity<>("User deleted successfully.", HttpStatus.OK);
	    }	
	 
	 @GetMapping("{productId}")
	 public ResponseEntity<Product> product(@PathVariable Integer productId)  {
	       

	        return ResponseEntity.ok(product_Service.getProduct(productId));
	    }
	 
	 
	 @GetMapping("/byname/{productName}")
	 public ResponseEntity<List<Product>> getProductsByName(@PathVariable String productName) {
	        List<Product> products = product_Service.getProductsByName(productName);
	        if (!products.isEmpty()) {
	            return ResponseEntity.ok(products);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 
}
