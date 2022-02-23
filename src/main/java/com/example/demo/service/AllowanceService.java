package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Allowance;

public interface AllowanceService {
	public void readData();
	public List<Allowance> getAllAllowances();
	public void updateAllowance(Allowance allowance,long id);

}
