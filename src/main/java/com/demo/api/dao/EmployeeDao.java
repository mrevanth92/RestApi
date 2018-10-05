package com.demo.api.dao;

import com.demo.api.beans.Employee;

public interface EmployeeDao {

	Employee save(Employee emp);
	
	Employee getEmployee(int id);
	
	Employee updateEmployee(Employee emp);
	
	Employee deleteEmployee(int id);
}
