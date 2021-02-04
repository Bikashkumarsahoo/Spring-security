package com.example.springsecurituy.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecurituy.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByName(String name);
}
