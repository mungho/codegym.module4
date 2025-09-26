package com.example.product_management.repository;

import com.example.product_management.entity.Product;

import com.example.product_management.utils.ConnectionUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{

    @Override
    public boolean addProduct(Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(product);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }


    @Override
    public boolean deleteProduct(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            Product productDelete = getProductById(id);
            session.remove(productDelete);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateProduct(Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            Product productUpdate = getProductById(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setSupplier(product.getSupplier());
            session.merge(productUpdate);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public Product getProductById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Product product = session.find(Product.class,id);
        session.close();
        return product;
    }

    @Override
    public Product findProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList =new ArrayList<>();
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query = session.createNativeQuery("select * from product",Product.class);
        productList = query.getResultList();
        session.close();
        return productList;
    }
}
