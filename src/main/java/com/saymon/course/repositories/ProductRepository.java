package com.saymon.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saymon.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}