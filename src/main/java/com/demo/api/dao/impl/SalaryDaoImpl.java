package com.demo.api.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.demo.api.beans.Employee;
import com.demo.api.dao.SalaryDao;

@Repository
public class SalaryDaoImpl implements SalaryDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public Integer getHighestSalary() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
		Root<Employee> c = cq.from(Employee.class);
		cq.select(cb.max(c.get("salary")));
		return em.createQuery(cq).getSingleResult();
		
	}

}
