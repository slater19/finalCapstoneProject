package com.foodbox.foodbox.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodbox.foodbox.model.Purchase;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    @Query("Select p FROM Purchase p WHERE p.customer.email LIKE %?1%")
    public List<Purchase> getByEmail(String email);

    public List<Purchase> findAllByOrderByTransactionidAsc();

    @Query("Select p FROM Purchase p WHERE p.transactionid LIKE %?1%"
            +" OR p.dop LIKE %?1%"
            +" OR p.productname LIKE %?1%"
            +" OR p.customer LIKE %?1%")
    public List<Purchase> searchPurchase(String keyword);
}
