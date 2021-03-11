package com.hcl.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.onetomany.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
