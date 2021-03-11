package com.hcl.onetomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.onetomany.entity.Brand;
import com.hcl.onetomany.repository.BrandRepository;

@Service
public class BrandService {
	@Autowired
	private BrandRepository repo;

	public void save(Brand brand) {
		repo.save(brand);
		
	}

	public List<Brand> getAll() {
		
		return repo.findAll();
	}

	public Brand findById(Integer id) {
		
		return repo.findById(id).get();
	}

	public void deleteBrand(Integer id) {
		repo.deleteById(id);
		
	}

}
