package com.crudApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.crudApplication.model.Product;
import com.crudApplication.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping("/")
	public String displayAllProducts(Model model) {
		List<Product> allProducts = service.getAllProducts();

		model.addAttribute("products", allProducts);
		return "index";
	}

	@GetMapping("/addProduct")
	public String postMethodName(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}

	@PostMapping("/saveProduct")
	public String saveproduct(@Valid @ModelAttribute Product product ,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "/addProduct";
		}
		service.saveProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/editProduct/{id}")
	public String editProduct(@PathVariable Integer id, Model model) {
		Product product = service.getProduct(id);
		model.addAttribute("product", product);
		return "editProduct";
	}
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		service.deleteProduct(id);
		return "redirect:/";
	}
	

}
