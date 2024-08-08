package com.sprinmvc.SpringMvc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sprinmvc.SpringMvc.service.EmployeeService;
import com.sprinmvc.SpringMvc.utilities.EmpModel;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empServ;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView employee(Model model, @RequestParam(required = false) Integer id,
			@RequestParam(required = false) String action) throws IOException {

		model.addAttribute("action", action);
		if ("update".equalsIgnoreCase(action)) {

			model.addAttribute("emp1", empServ.getEmployeeService(id));

		} else if ("delete".equalsIgnoreCase(action)) {

			int result = empServ.deleteEmployeeService(id);

			if (result == 0)
				System.out.println("not deleted");
			else
				System.out.println(id + " deleted");
		}

		ModelAndView view = new ModelAndView("employee");

		List<EmpModel> list = empServ.getAllEmployeesService();

		model.addAttribute("empList", list);

		return view;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView addEmployee(Model model, EmpModel emp) throws IOException {
		int result = 0;
		if (emp.getEmp_id() == 0) {
			result = empServ.addEmployeeService(emp);
		} else {
			result = empServ.updateEmployeeService(emp);
		}

		if (result == 0)
			System.out.println("not successful");
		else
			System.out.println("successful");

		ModelAndView view = new ModelAndView("employee");

		List<EmpModel> list = empServ.getAllEmployeesService();

		model.addAttribute("empList", list);

		return view;
	}
}
