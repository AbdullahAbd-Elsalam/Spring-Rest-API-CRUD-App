package com.dummyApp.service;

import com.dummyApp.Exception.EmptyException;
import com.dummyApp.Exception.ProductNotFoundError;
import com.dummyApp.Exception.TypeNotMatchException;
import com.dummyApp.dao.ProductDAO;
import com.dummyApp.model.Product;
import com.dummyApp.model.ProductDetails;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public  class ProductServiceImp  implements  ProductService{

    // inject productDAO
    @Autowired
    private   ProductDAO productDAO;


    @Transactional
    public void insert(ProductDetails productDetails) throws EmptyException {

          // do some validation on data before go on dataAccess Layer
        if(!productDetails.getName().isEmpty()){
              productDAO.insert(productDetails);

        }else {
             throw  new EmptyException("the name should not be null");

        }




     }


    @Transactional
    public Product findById(int id) throws ProductNotFoundError {

        Product product= productDAO.findById(id);

        if(id<=0 || id>1000)
            throw new ProductNotFoundError("id should greater than 0 or less than 1000");
        else if(product == null)
            throw  new ProductNotFoundError("the id is null or not found ");
        else
            return product;


    }

     @Transactional
    public void deleteById(int id) {

        productDAO.deleteById(id);
    }

    @Transactional
    public ProductDetails update(ProductDetails productDetails) throws ProductNotFoundError, EmptyException, TypeNotMatchException {

           // search for related product exist or not
          Product product= productDAO.findByProductDetails(productDetails);
                if(productDetails.getPrice()==0 || productDetails.getPrice()<0 ||
                        productDetails.getPrice()>20000){
                    throw new ProductNotFoundError("the price must greater than 0 or less than 20000");
                }
                if(productDetails.getPrice()==null)
                    throw new EmptyException("the price should'nt  be null ");
                else {
                    productDAO.update(productDetails);

                }




        return productDetails;
    }

  @Transactional
    public List<Product> getAllProducts() {

        return   productDAO.getAllProducts();
    }

    @Transactional
    public List<Product> search(String name) {
       List<Product>  products= productDAO.search(name);
        return products;
    }


    // make method for validation
}
