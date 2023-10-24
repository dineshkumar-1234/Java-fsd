package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

}
