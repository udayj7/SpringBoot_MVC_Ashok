package com.uday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.uday.entity.Student;
import com.uday.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/")
	public String loadIndexPage(Model model) {
		init(model);
		return "index";
	}

	private void init(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("courses", service.getCourses());
		model.addAttribute("prefTimings", service.getTimings());
	}

	@PostMapping("/save")
	public String handleSubmitBtn(Student s, Model model) {
		model.addAttribute("msg", "Data Saved...");
		init(model);
		return "index";
	}
}
