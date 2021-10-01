package com.simplilearn.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
