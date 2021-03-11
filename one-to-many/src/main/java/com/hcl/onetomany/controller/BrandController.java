package com.hcl.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hcl.onetomany.entity.Brand;
import com.hcl.onetomany.entity.Category;
import com.hcl.onetomany.service.BrandService;
import com.hcl.onetomany.service.CategoryService;
@Controller
public class BrandController {
	@Autowired
	private BrandService service;
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/brands")
	public String listCategories(Model model) {
		List<Brand> listBrands = service.getAll();
		model.addAttribute("listBrands", listBrands);
		return "brands";
	}

	@GetMapping("/brands/new")
	public String showCategoryNewForm(Model model) {
		List<Category> listCategories=categoryService.getAll();
		model.addAttribute("brand", new Brand());
		model.addAttribute("listCategories", listCategories);
		return "brand_form";
	}

	@PostMapping("/brands/save")
	public String saveBrand(Brand brand) {
		service.save(brand);
		return "redirect:/brands";
	}
	
	@GetMapping("brands/edit/{id}")
	public String showBrandEditForm(@PathVariable("id") Integer id, Model model) {
		Brand brand = service.findById(id);
		List<Category> listCategories = categoryService.getAll();
		model.addAttribute("listCategories",listCategories);
		model.addAttribute("brand", brand);
		return "brand_form";
	}

	@GetMapping("brands/delete/{id}")
	public String deleteBrand(@PathVariable("id") Integer id, Model model) {
		service.deleteBrand(id);
		return "redirect:/brands";
	}


}
