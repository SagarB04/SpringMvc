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

import com.sprinmvc.SpringMvc.service.DepartmentService;
import com.sprinmvc.SpringMvc.utilities.DeptModel;

@Controller
public class DepartmentController {

	@Autowired
	DepartmentService deptServ;

	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public ModelAndView department(Model model, @RequestParam(required = false) String action,
			@RequestParam(required = false) Integer id) throws IOException {

		model.addAttribute("action", action);

		if ("update".equalsIgnoreCase(action)) {
			model.addAttribute("department", deptServ.getOneDeptService(id));

		} else if ("delete".equalsIgnoreCase(action)) {

			int res = deptServ.deleteDeptService(id);
			if (res == 0)
				System.out.println("not succesful");
			else
				System.out.println("successful");
		}

		ModelAndView view = new ModelAndView("department");

		List<DeptModel> list = deptServ.getAllDeptService();
		model.addAttribute("dept", list);

		return view;
	}

	@RequestMapping(value = "/department", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView addDepartment(Model model, DeptModel dept) {
		int res = 0;
		if (dept.getDept_id() == 0) {
			res = deptServ.addDeptService(dept);
		} else {
			res = deptServ.updateDeptService(dept);
		}

		if (res == 0)
			System.out.println("not succesful");
		else
			System.out.println("successful");

		ModelAndView view = new ModelAndView("department");

		List<DeptModel> list = deptServ.getAllDeptService();
		model.addAttribute("dept", list);

		return view;

	}
}
