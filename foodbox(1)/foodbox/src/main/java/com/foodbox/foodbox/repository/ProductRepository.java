package com.foodbox.foodbox.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodbox.foodbox.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query("Select p FROM Product p WHERE p.avail='yes' ORDER BY 'category'")
    List<Product> findIfAvail();

    @Query("SELECT p FROM Product p WHERE (p.avail LIKE 'yes') AND (p.name LIKE %?1%"
            +" OR p.des LIKE %?1%"
            +" OR p.price LIKE %?1%"
            +" OR p.category LIKE %?1%)")
    public List<Product> homeSearch(String keyword);

    @Query("SELECT p FROM Product p WHERE p.category LIKE 'Chinese' AND p.avail LIKE 'yes'")
    public List<Product> getChinese();

    @Query("SELECT p FROM Product p WHERE p.category LIKE 'Indian' AND p.avail LIKE 'yes'")
    public List<Product> getIndian();

    @Query("SELECT p FROM Product p WHERE p.category LIKE 'Mexican' AND p.avail LIKE 'yes'")
    public List<Product> getMexican();

    @Query("SELECT p FROM Product p WHERE p.category LIKE 'Italian' AND p.avail LIKE 'yes'")
    public List<Product> getItalian();
}