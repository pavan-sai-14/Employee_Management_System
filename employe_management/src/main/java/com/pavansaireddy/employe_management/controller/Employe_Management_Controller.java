package com.pavansaireddy.employe_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pavansaireddy.employe_management.model.Employee;
import com.pavansaireddy.employe_management.service.EmployeService;

@Controller
public class Employe_Management_Controller {
	
	@Autowired
	EmployeService employeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listEmployees",employeService.getAllEmployee());
		return "index";
	}
	
	@ModelAttribute("employee")
    public Employee userRegistrationDto() {
        return new Employee();
    }
	
	@GetMapping("/employeeByName")
	public String ShowEmployeByName(@ModelAttribute("employee") Employee e,Model model)
	{
		List<Employee> eList=employeService.getAllEmployeeByName(e.getFirstName());
		model.addAttribute("listEmployees",eList);
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model)
	{
		Employee e=new Employee();
		model.addAttribute("employee",e);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee e)
	{
		employeService.saveEmploye(e);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id")long id,Model model)
	{
		Employee e=employeService.getEmployeeById(id);
		model.addAttribute("employee", e);
		return "update_employee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value="id") long id)
	{
		employeService.deleteEmployeeById(id);
		return "redirect:/";
	}
}
