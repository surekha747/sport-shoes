package com.simplilearn.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.model.ColorCategory;

public interface ColorRepository extends JpaRepository<ColorCategory, Long> {
}
