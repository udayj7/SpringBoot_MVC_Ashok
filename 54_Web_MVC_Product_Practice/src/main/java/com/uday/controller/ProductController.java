package com.uday.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uday.entity.Product;
import com.uday.repo.ProductRepository;


@Controller
public class ProductController {

	@Autowired
	private ProductRepository repo;

	@GetMapping("/pro")
	public String getBookId(@RequestParam(name = "id", required = false, defaultValue = "0") Integer id, Model model) {
		Optional<Product> findById = repo.findById(id);
		if (findById.isPresent()) {
			Product productObj = findById.get();
			model.addAttribute("product", productObj);
		}
		return "data";
	}

	@GetMapping("/save")
	public String handleSubmitBtn(Product p, Model model) {
		model.addAttribute("msg", repo.save(p));
		init(model);
		return "index";
	}

	private void init(Model model) {
		model.addAttribute("msg", new Product());
	}
}

