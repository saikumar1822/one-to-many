package com.hcl.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hcl.onetomany.entity.Category;
import com.hcl.onetomany.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService service;

	@GetMapping("/categories")
	public String listCategories(Model model) {
		List<Category> listCategories = service.getAll();
		model.addAttribute("listCategories", listCategories);
		return "categories";
	}

	@GetMapping("/categories/new")
	public String showCategoryNewForm(Model model) {
		model.addAttribute("category", new Category());
		return "category_form";
	}

	@PostMapping("/categories/save")
	public String saveCategory(Category category) {
		service.saveCategory(category);
		return "redirect:/categories";
	}

}
