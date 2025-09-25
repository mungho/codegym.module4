package com.example.product_management.repository;

import com.example.product_management.entity.Product;

import com.example.product_management.utils.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    private static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "Bánh mì heo quay", 25000, "Bánh mì thịt heo quay", "Anh Quân"));
        products.add(new Product(2, "Bánh mì chả", 20000, "Bánh mì chả", "Anh Quân"));
        products.add(new Product(3, "Bánh mì thập cẩm", 30000, "Bánh mì chả, thịt nướng", "Anh Quân"));
    }

//    @Override
//    public boolean addProduct(Product product) {
//        Session session = ConnectionUtil.sessionFactory.openSession();
//        Transaction transaction = session.getTransaction();
//        try {
//            transaction.begin();
//            session.persist(product);
//            transaction.commit();
//        } catch (Exception e){
//            transaction.rollback();
//            return false;
//        }
//        return true;
//    }

    @Override
    public boolean addProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.persist(product);  // hoặc session.save(product);

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        products.remove(getProductById(id));
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        for(Product p:products){
            if(p.getId()==product.getId()){
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setSupplier(product.getSupplier());
                return true;
            }
        }
        return false;
    }

    @Override
    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }
}
