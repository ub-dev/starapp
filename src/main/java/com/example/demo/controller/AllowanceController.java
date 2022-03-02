package com.example.demo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Allowance;
import com.example.demo.repository.AllowanceRepository;
import com.example.demo.service.AllowanceService;

@CrossOrigin
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
	public void getAllAllowances() throws IOException {
		allowanceService.readData();
	}

	@PutMapping("/update") // to be tested
	public void updateAllowance(@RequestBody Allowance allowance) {
		allowanceService.updateAllowance(allowance);
	}

	@GetMapping("/distinct")
	public List<String> getDistinctProject() {
		return allowanceService.getDistinctProject();
	}

	@GetMapping("/getprojects/{project_name}")
	public List<Allowance> getAllowancesByProjectName(@PathVariable(value = "project_name") String projectName) {
		return allowanceService.getAllowancesByProjectName(projectName);
	}

	@GetMapping("getprojects/{pname}/{startdate}/{enddate}")
	public List<Allowance> getAllowances(@PathVariable(value = "pname") String pname,
			@PathVariable(value = "startdate") String startdate, @PathVariable(value = "enddate") String enddate)
			throws IOException, ParseException {

		List<Allowance> list = allowanceService.getAllAllowancesByProjectNameAndPeriod(pname, startdate, enddate);
		return list;
	}

	@PutMapping("/updateAll")
	public void updateAll(@RequestBody List<Allowance> list) {
		allowanceService.updateAll(list);
	}

}
