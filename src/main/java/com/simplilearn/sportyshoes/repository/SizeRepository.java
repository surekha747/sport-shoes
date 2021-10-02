package com.simplilearn.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.model.SizeCategory;

public interface SizeRepository extends JpaRepository<SizeCategory, Long> {
	
}
