package com.simplilearn.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.model.ShoesCategory;


public interface ShoesCategoryRepository extends JpaRepository<ShoesCategory, Long> {

}
