package com.flowerShop.flowershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flowerShop.flowershop.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
