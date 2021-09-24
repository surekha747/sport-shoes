package com.simplilearn.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyshoes.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
