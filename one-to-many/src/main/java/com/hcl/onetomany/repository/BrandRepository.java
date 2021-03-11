package com.hcl.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.onetomany.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
