package com.hcl.onetomany.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hcl.onetomany.entity.Category;
import com.hcl.onetomany.entity.Product;
import com.hcl.onetomany.service.CategoryService;
import com.hcl.onetomany.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService prodService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/products")
	public String listProducts(Model model) {
		List<Product> listProducts = prodService.getAll();
		model.addAttribute("listProducts", listProducts);
		return "products";
	}

	@GetMapping("/products/new")
	public String showProductNewForm(Model model) {
		List<Category> listCategories = categoryService.getAll();
		model.addAttribute("product", new Product());
		model.addAttribute("listCategories", listCategories);
		return "Product_form";
	}

	@PostMapping("/products/save")
	public String saveProduct(Product product, HttpServletRequest request) {
		String[] detailIds = request.getParameterValues("detailId");
		String[] detailNames = request.getParameterValues("detailName");
		String[] detailValues = request.getParameterValues("detailValue");
		for (int i = 0; i < detailNames.length; i++) {
			if (detailIds != null && detailIds.length > 0) {
				product.setDteail(Integer.valueOf(detailIds[i]), detailNames[i], detailValues[i]);
			} else {
				product.addDetail(detailNames[i], detailValues[i]);
			}
		}
		prodService.save(product);
		return "redirect:/products";
	}

	@GetMapping("products/edit/{id}")
	public String showProductEditForm(@PathVariable("id") Integer id, Model model) {
		Product product = prodService.findById(id);
		List<Category> listCategories = categoryService.getAll();
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("product", product);
		return "Product_form";
	}

	@GetMapping("products/delete/{id}")
	public String deleteProduct(@PathVariable("id") Integer id, Model model) {
		prodService.deleteProduct(id);
		return "redirect:/products";
	}

}
