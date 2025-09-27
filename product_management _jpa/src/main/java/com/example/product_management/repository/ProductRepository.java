package com.example.product_management.repository;



import com.example.product_management.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public boolean addProduct(Product product) {
        try{
            entityManager.persist(product);
        }catch (Exception e){
            return false;
        }
        return true;
    }


    @Transactional
    @Override
    public boolean deleteProduct(int id) {
        try{
            entityManager.remove(entityManager.find(Product.class, id));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean updateProduct(Product product) {
        try {
            entityManager.merge(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Product getProductById(int id) {
        TypedQuery<Product> query = entityManager.createQuery("FROM Product p WHERE p.id = :id",Product.class);
        query.setParameter("id", id);
        Product product = query.getSingleResult();
        return product;
    }

    @Override
    public Product findProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        TypedQuery<Product> query = entityManager.createQuery("from Product ",Product.class);
        productList = query.getResultList();
        return productList;
    }
}
