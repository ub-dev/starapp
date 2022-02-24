package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.Allowance;

public interface AllowanceService {
	public void readData() throws IOException;
	public List<Allowance> getAllAllowances();
	public void updateAllowance(Allowance allowance);

}
