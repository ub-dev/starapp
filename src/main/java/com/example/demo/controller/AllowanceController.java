package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Allowance;
import com.example.demo.repository.AllowanceRepository;
import com.example.demo.service.AllowanceService;

@RestController
@RequestMapping("/allowance")
public class AllowanceController {
	
	@Autowired
	AllowanceService allowanceService;

	@PutMapping("/{id}")
	public void getUserAllowances(@RequestBody Allowance allowance,@PathVariable(value="id") long SAPId)
	{
		 allowanceService.updateAllowance(allowance,SAPId);
	}

}
