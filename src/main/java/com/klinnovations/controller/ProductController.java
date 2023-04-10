package com.klinnovations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.klinnovations.entity.Product;
import com.klinnovations.repository.ProductRepository;

@Controller
public class ProductController {

	//injecting 
	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/delete")
	public String delete(@RequestParam("pid") Integer pid, Model model) {
		
		
		repo.deleteById(pid);
		model.addAttribute("msg", "Product Deleted...");
		  model.addAttribute("products", repo.findAll());
		return"data";
		
		
	}

	//Saving Product Detail
	@PostMapping("/product")
	public String saveProduct(@ModelAttribute("product") Product p, Model model) {
		p = repo.save(p);
		if (p.getPid() != null) {
			model.addAttribute("msg", "Product Saved...!");
		}
		return "index";
	}

	//Loading Page
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("product", new Product());
		return "index";

	}
	
	@GetMapping("/products")
	public String getAllProducts(Model model) {
		
		List<Product> list = repo.findAll();
		model.addAttribute("products", list);
		
		return "data";
		
		
	}
	

}
