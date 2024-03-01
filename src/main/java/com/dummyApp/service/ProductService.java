package com.dummyApp.service;

import com.dummyApp.Exception.EmptyException;
import com.dummyApp.Exception.ProductNotFoundError;
import com.dummyApp.Exception.TypeNotMatchException;
import com.dummyApp.model.Product;
import com.dummyApp.model.ProductDetails;

import java.util.List;

public interface ProductService {

    void insert(ProductDetails product) throws EmptyException;
    Product findById(int id) throws ProductNotFoundError;
    void deleteById(int id);
    ProductDetails update(ProductDetails product) throws ProductNotFoundError, EmptyException, TypeNotMatchException;
    List<Product> getAllProducts();
    List<Product> search(String name);
}
