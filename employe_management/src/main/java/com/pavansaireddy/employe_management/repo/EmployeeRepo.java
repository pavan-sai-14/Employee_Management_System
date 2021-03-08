package com.pavansaireddy.employe_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pavansaireddy.employe_management.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
