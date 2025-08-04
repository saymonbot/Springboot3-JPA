package com.saymon.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saymon.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}