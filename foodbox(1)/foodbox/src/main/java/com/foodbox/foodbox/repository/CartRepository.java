package com.foodbox.foodbox.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.foodbox.foodbox.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
