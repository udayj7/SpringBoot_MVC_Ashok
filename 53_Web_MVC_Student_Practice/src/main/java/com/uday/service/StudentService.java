package com.uday.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	public List<String> getCourses() {
		return Arrays.asList("JAva", "Pyhton", "AWs", "DEvops", "Js");
	}

	public List<String> getTimings()
	{
		return Arrays.asList("Morning", "Afternoon","Evening");
	}
}
