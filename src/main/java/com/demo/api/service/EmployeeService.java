package com.demo.api.service;

import com.demo.api.beans.Employee;

public interface EmployeeService {
	Employee getEmployee(int id);
	Employee saveEmployee(Employee emp);
	Employee updateEmployee(Employee emp);
	Employee deleteEmployee(int id);
}
