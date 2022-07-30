package br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloCrontroller {
	
	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
		request.setAttribute("nome", "Mundo");
		return "hello";
	}

}
