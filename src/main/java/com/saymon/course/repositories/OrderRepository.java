package com.saymon.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saymon.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
