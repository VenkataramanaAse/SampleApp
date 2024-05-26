package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;
import com.example.demo.Exceptions.InvalidPhnumberException;

public interface Product_Service {
	public Product saveProduct(Product product) ;
	
    public List<Product> get_Product();
    
    public void deleteProduct(Integer productId);
    
     Product getProduct(Integer productId);
//     public Product getProductByName(String productName);

	public List<Product> getProductsByName(String productName);
}
