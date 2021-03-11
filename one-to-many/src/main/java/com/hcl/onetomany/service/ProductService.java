package com.hcl.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.onetomany.entity.Product;
import com.hcl.onetomany.repository.ProductRepository;

@Service
public class ProductService {
@Autowired
private ProductRepository repo;

public List<Product> getAll(){
	return repo.findAll();
}

public void save(Product product) {
	repo.save(product);
}

public Product findById(Integer id) {
	return repo.findById(id).get();
	
}

public void deleteProduct(Integer id) {
	repo.deleteById(id);
	
}



}
