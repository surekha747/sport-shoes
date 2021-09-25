package com.simplilearn.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyshoes.model.SignedUsers;

@Repository
public interface SignedUserRepository extends JpaRepository<SignedUsers, Long>{
	List<SignedUsers> findByEmail(String email);
}
