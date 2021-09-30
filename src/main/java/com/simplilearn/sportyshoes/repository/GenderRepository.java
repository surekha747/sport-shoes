package com.simplilearn.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.model.Color;
import com.simplilearn.sportyshoes.model.Gender;

public interface GenderRepository extends JpaRepository<Gender, Long>{

}
