package com.pcy.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcy.security.model.User;

//JPA는 기본 CRUD를 JpaRepository가 상속하는 CrudRepository가 가지고 있음.

// JpaRepository 를 상속하면 자동 컴포넌트 스캔됨.
public interface UserRepository extends JpaRepository<User, Integer>{
	// SELECT * FROM user WHERE username = ?1
	User findByUsername(String username);
	
	// SELECT * FROM user WHERE provider = ?1 and providerId = ?2
	Optional<User> findByProviderAndProviderId(String provider, String providerId);
}