package com.uday.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uday.entity.Book;
import com.uday.repo.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repo;

	@GetMapping("/book")
	public String getBookId(@RequestParam(name = "id", 
	required = false, defaultValue = "0") Integer id,
			Model model) {
		Optional<Book> findById = repo.findById(id);
		if (findById.isPresent()) {
			Book bookObj = findById.get();
			model.addAttribute("book", bookObj);
		}
		return "index";
	}
//	@GetMapping("/book")
//	public ModelAndView getBookId(@RequestParam(name = "id", required = false, defaultValue = "0") Integer id)
//	{
//		ModelAndView mav = new ModelAndView();
//		Optional<Book> findById = repo.findById(id);
//		if (findById.isPresent()) {
//			Book bookObj = findById.get();
//			// sending data to view
//			mav.addObject("book", bookObj);
//		}
//		// setting view page name
//		mav.setViewName("index");
//		return mav;
//	}
}
