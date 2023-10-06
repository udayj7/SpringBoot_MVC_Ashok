package com.uday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MsgController {

	@GetMapping("/welcome")
	public String getWelcomeMsg(Model mav) {
		mav.addAttribute("msg", "Hi, Welcome to thymleaf project");
		return "hi";
	}

}
