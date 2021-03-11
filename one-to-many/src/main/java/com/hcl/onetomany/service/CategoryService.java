package com.hcl.onetomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.onetomany.entity.Category;
import com.hcl.onetomany.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> getAll(){
		return repo.findAll();
	}

	public void saveCategory(Category category) {
		repo.save(category);
	}

}
