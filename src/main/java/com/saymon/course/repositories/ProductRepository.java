package com.saymon.course.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saymon.course.entities.Category;
import com.saymon.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
