package com.projetowebservice.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetowebservice.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	

}
