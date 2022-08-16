package com.soccer_bill_splitter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.soccer_bill_splitter.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	boolean existsByEmail(String email);

	Optional<User> findByEmail(String username);

	@Query("select u.userName from User u")
	List<String> findAllNames();

	Optional<User> findByEmailAndPassword(String email, String password);

}
