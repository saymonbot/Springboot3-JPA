package com.saymon.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saymon.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
