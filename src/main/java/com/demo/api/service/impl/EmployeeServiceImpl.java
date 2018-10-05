package com.demo.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.api.beans.Employee;
import com.demo.api.dao.EmployeeDao;
import com.demo.api.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao dao;
	
	@Override
	public Employee getEmployee(int id) {
		return dao.getEmployee(id);
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return dao.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return dao.updateEmployee(emp);
	}

	@Override
	public Employee deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}

}
