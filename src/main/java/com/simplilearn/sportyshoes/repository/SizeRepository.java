package com.simplilearn.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.model.Color;
import com.simplilearn.sportyshoes.model.Size;

public interface SizeRepository extends JpaRepository<Size, Long> {
	
}
