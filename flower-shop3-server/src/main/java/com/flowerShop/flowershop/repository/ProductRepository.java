package com.flowerShop.flowershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flowerShop.flowershop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
