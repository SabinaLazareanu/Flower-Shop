package com.flowerShop.flowershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flowerShop.flowershop.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
