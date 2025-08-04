package com.saymon.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saymon.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}