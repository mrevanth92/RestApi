package com.demo.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.api.dao.SalaryDao;
import com.demo.api.service.SalaryService;

@Service
public class SalaryServiceImpl implements SalaryService {
	
	@Autowired
	SalaryDao dao;

	@Override
	public Integer getHighestSalary() {
		return dao.getHighestSalary();
	}

}
