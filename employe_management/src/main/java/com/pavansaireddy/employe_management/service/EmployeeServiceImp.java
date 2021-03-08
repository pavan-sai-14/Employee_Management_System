package com.pavansaireddy.employe_management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavansaireddy.employe_management.model.Employee;
import com.pavansaireddy.employe_management.repo.EmployeeRepo;

@Service
public class EmployeeServiceImp implements EmployeService{

	@Autowired
	EmployeeRepo employeeRepo;
	
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	@Override
	public void saveEmploye(Employee e) {
		employeeRepo.save(e);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Employee e=null;
		Optional<Employee> employee=employeeRepo.findById(id);
		if(employee.isPresent())
		{
			e=employee.get();
		}
		else
		{
			throw new RuntimeErrorException(new Error("Employee Not Found with given id"));
		}
		return e;
	}

	@Override
	public void deleteEmployeeById(long id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployeeByName(String name) {
		List<Employee> eList1=employeeRepo.findAll();
		List<Employee> eList2=new ArrayList<>();
		int l=name.length();
		for(int i=0;i<eList1.size();i++)
		{
			String temp=eList1.get(i).getFirstName();
			for(int j=0;j<temp.length()-l+1;j++)
			{
				if(temp.substring(j, j+l).equalsIgnoreCase(name))
				{
					eList2.add(eList1.get(i));
					break;
				}
			}
			temp=eList1.get(i).getLastName();
			for(int j=0;j<temp.length()-l+1;j++)
			{
				if(temp.substring(j, j+l).equalsIgnoreCase(name) && !eList2.contains(eList1.get(i)))
				{
					eList2.add(eList1.get(i));
					break;
				}
			}
		}
		return eList2;
	}

}
