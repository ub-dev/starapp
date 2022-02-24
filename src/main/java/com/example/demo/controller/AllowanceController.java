package com.example.demo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Allowance;
import com.example.demo.repository.AllowanceRepository;
import com.example.demo.service.AllowanceService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("allowance")
public class AllowanceController {

	@Autowired
	AllowanceService allowanceService;
	@Autowired
	AllowanceRepository allowanceRepository;

	@GetMapping("/")
	public String home() {
		return "allowance";
	}

	@GetMapping("get")
	public Set<String> getAllAllowances() throws IOException {
		System.out.println("allowance service");
		//allowanceService.readData();
		List<Allowance> list = allowanceService.getAllAllowances();
		Set<String> projectName=new HashSet<>();

		for(Allowance obj:list)

			{
	               projectName.add(obj.getProjectName());
		
			}
		return projectName;
	}
	
	@PutMapping("/update") // to be tested
	public void updateAllowance(@RequestBody Allowance allowance) {
		allowanceService.updateAllowance(allowance);
	}
	
	@GetMapping("distinct")
	public ArrayList<String> getDistinctProject(){
		return allowanceRepository.findDistinctByProjectName();
	}
	
	@GetMapping("/getprojects/{project_name}")
	public List<Allowance> getAllowancesByProjectName(@PathVariable(value = "project_name") String projectName) {
		return allowanceRepository.findAllByProjectName(projectName).stream().toList();
	}
	

	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@GetMapping("getprojects/{pname}/{startdate}/{enddate}")
	public List<Allowance> getAllowances(@PathVariable(value = "pname") String pname,
			@PathVariable(value = "startdate") String startdate, @PathVariable(value = "enddate") String enddate)
			throws IOException, ParseException {
		System.out.println("allowance service");
		Date start=new SimpleDateFormat("yyyy-MM-dd").parse(startdate);
		Date end = new SimpleDateFormat("yyyy-MM-dd").parse(enddate);
		
		List<Allowance> list = allowanceRepository.getProjectNameAndPeriod(pname, start, end);
		return list;
	}

}
