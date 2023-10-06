package com.uday.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
