package com.hcl.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.onetomany.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
