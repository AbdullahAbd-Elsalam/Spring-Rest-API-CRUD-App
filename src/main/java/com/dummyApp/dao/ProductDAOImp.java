package com.dummyApp.dao;

import com.dummyApp.model.Product;
import com.dummyApp.model.ProductDetails;
import org.hibernate.*;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class ProductDAOImp  implements ProductDAO{

    // inject session factory on this class
    @Autowired
    SessionFactory sessionFactory;

    public Product insert(ProductDetails productDetails) {

        try {
            // frist define object of product
            Product product=new Product(productDetails.getName());
            product.setProductDetails(productDetails);
            getSession().persist(product);

            return product;
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }


    public Product findById(int id) {

        // frist get product by id
       Product product= getSession().get(Product.class,id);
//        // second get all product details
//         int detail_id=  product.getProductDetails().getId();
//         getSession().get(ProductDetails.class,detail_id);
        return product;
    }


    public Product findByProductDetails(ProductDetails productDetails) {

                // second get all product details
           Product product=new Product(productDetails.getName());

         int id=  product.getId();

        return  getSession().get(Product.class,id);
    }


    public void deleteById(int id) {

        try {
            Product productDelete= getSession().get(Product.class,id);

            if(productDelete != null)
            {

                // define hql
                Query query = getSession().createQuery("delete  from Product  where id=:id");
                // set id by parameter id
                query.setParameter("id", id);
                // execute query
                query.executeUpdate();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
     }


    public void update(ProductDetails productDetails) {

        try{
            // get all product details
            ProductDetails oldProductDetials=getSession().get(ProductDetails.class,productDetails.getId());
            // get old product
            Product oldProduct=oldProductDetials.getProduct();

            // set old values to new values that get from user
            oldProduct.setName(productDetails.getName());
            oldProductDetials.setName(productDetails.getName());
            oldProductDetials.setExpirationDate(productDetails.getExpirationDate());
            oldProductDetials.setPrice(productDetails.getPrice());
            oldProductDetials.setAvailable(productDetails.getAvailable());
            oldProductDetials.setManufacturer(productDetails.getManufacturer());
            // get old product in oldProduct details
            oldProductDetials.setProduct(productDetails.getProduct());
            // set all product details in product
            oldProduct.setProductDetails(oldProductDetials);


            getSession().update(oldProduct);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public List<Product> getAllProducts() {

    // use hql

       Query query=  getSession().createQuery("from Product ");
      List<Product> products=   query.getResultList();
        return products ;
    }


    public List<Product> search(String newName) {
         Query query = getSession().createQuery(" from Product  where name=:name");
        query.setParameter("name", newName);

        List<Product> products = query.getResultList();

        return products;
    }



    // define session factory to get session
    public Session getSession() {

        // define session factory

        Session session=sessionFactory.getCurrentSession();
        return session;
    }

}
