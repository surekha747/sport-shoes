package com.simplilearn.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.model.Color;
import com.simplilearn.sportyshoes.model.User;

public interface ColorRepository extends JpaRepository<Color, Long> {
	
}
