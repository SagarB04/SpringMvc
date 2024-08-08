package com.sprinmvc.SpringMvc.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public ModelAndView landing() throws IOException {
		return new ModelAndView("landing");
	}

	@RequestMapping(value = "/home")
	public ModelAndView home() throws IOException {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() throws IOException {
		return new ModelAndView("contact");
	}

}
