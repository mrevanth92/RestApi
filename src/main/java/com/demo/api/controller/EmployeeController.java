package com.demo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.api.beans.Employee;
import com.demo.api.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getemployee(@PathVariable("id") int id) {
		Employee emp = service.getEmployee(id);
		if (emp == null) {
			return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> persistEmployee(@RequestBody Employee employee) {
		try {
			Employee emp = service.saveEmployee(employee);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("error:" + e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		try {
			Employee emp = service.updateEmployee(employee);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("error:" + e, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
		try {
			Employee emp = service.deleteEmployee(id);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("error:" + e, HttpStatus.BAD_REQUEST);
		}
	}

}
