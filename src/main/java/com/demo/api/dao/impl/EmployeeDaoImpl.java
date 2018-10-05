package com.demo.api.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.demo.api.beans.Employee;
import com.demo.api.dao.EmployeeDao;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@PersistenceContext
	private EntityManager em;
	
	private Employee getEmployeeById(int id){
		Employee emp = em.find(Employee.class, id);
		return emp;
	}

	@Override
	@Transactional
	public Employee save(Employee emp) {
		em.persist(emp);
		return emp;
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		return getEmployeeById(id);
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee emp) {
		return em.merge(emp);
	}

	@Override
	@Transactional
	public Employee deleteEmployee(int id) {
		Employee emp = getEmployeeById(id);
		em.remove(emp);
		return emp;
	}
	
	

}
