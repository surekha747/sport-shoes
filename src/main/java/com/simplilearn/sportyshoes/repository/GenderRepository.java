package com.simplilearn.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.model.GenderCategory;



public interface GenderRepository extends JpaRepository<GenderCategory, Long>{

}
