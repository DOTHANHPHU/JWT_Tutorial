package com.phu.springsecurity.repository;

import com.phu.springsecurity.entity.Products;
import com.phu.springsecurity.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

    Optional<Products> findByProductName(String productName);
}
