package com.pavansaireddy.employe_management.service;

import java.util.List;

import com.pavansaireddy.employe_management.model.Employee;

public interface EmployeService {
	List<Employee> getAllEmployee();
	void saveEmploye(Employee e);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	List<Employee> getAllEmployeeByName(String name);
}
