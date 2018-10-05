package com.demo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.api.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController {

	@Autowired
	SalaryService service;

	@RequestMapping(value = "/highest", method = RequestMethod.GET)
	public ResponseEntity<?> getHighestSalary() {
		try {
			Integer salary = service.getHighestSalary();
			if (salary == null) {
				return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(salary, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("error:" + e, HttpStatus.BAD_REQUEST);
		}
	}
}
