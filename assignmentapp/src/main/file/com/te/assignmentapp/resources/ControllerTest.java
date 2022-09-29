package com.te.assignmentapp.resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.te.assignmentapp.Employee.Employee;
import com.te.assignmentapp.respo.Employe;

@Controller
public class ControllerTest {

	@GetMapping("/register")
	public String register() {
		return "WEB-INF/views/form.jsp";

	}

	@PostMapping("/adding")
	public String adding(@ModelAttribute Employee emp, Employe respo) {
		respo.save(emp);
		return "WEB-INF/views/success.jsp";
	}

	@GetMapping("/search")
	public String search() {

		return "WEB-INF/views/search.jsp";
	}

	@PostMapping("/searchprocess")
	public String searchProcess(@RequestParam("name") String name, @ModelAttribute Employe emp, Model model) {
		System.out.println(name);
		Employee retrive = emp.retrive(name);
		Employee employee = emp.getE();
		model.addAttribute("employee", retrive);
		return "WEB-INF/views/display.jsp";
	}

	@GetMapping("/delete")
	public String delete() {
		return "WEB-INF/views/deleteprocess.jsp";
	}

	@GetMapping("/deleteprocess")
	public String deleteprocess(@RequestParam("name") String name, @ModelAttribute Employe emp, Model model) {

		emp.delete(name);
		Employee employee = emp.getE();
		model.addAttribute("employee", employee);
		return "WEB-INF/views/success.jsp";
	}

	@GetMapping("/edit")
	public String update() {
		return "WEB-INF/views/updateprocess.jsp";
	}

	@GetMapping("/edit")
	public String updateProcess(@RequestParam("name"),@RequestParam("updatename") String name, @ModelAttribute Employe emp, Model model) {
		emp.update(name);
		Employee employee = emp.getE();
		model.addAttribute("employee", employee);
		return "WEB-INF/views/success.jsp";
	}

}
