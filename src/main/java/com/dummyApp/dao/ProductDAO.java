package com.dummyApp.dao;

import com.dummyApp.model.Product;
import com.dummyApp.model.ProductDetails;

import java.util.List;

public interface ProductDAO {

   // insert all product details
    Product insert(ProductDetails product);
    // find product by id
    Product findById(int id);
    // get product details
    Product findByProductDetails(ProductDetails productDetails);
    // delete product by id
    void deleteById(int id);
    // update product details
    void update(ProductDetails product);
    // get list of product
    List<Product> getAllProducts();
    // make search by product name
    List<Product> search(String newName);



}
