package com.example.demo.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.example.demo.model.Allowance;

public interface AllowanceService {
	public void readData() throws IOException;
	public List<Allowance> getAllAllowancesByProjectNameAndPeriod(String pname,String startdate,String enddate) throws ParseException;
	public void updateAllowance(Allowance allowance);
	public List<String> getDistinctProject();
	public List<Allowance> getAllowancesByProjectName(String projectName);
	public void updateAll(List<Allowance> list);

}
