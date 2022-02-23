package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Allowance;
import com.example.demo.repository.AllowanceRepository;

public class AllowanceServiceImpl implements AllowanceService{

	@Autowired
	AllowanceRepository allowanceRepository;
	@Override
	public List<Allowance> getAllAllowances() {
		return allowanceRepository.findAll();
		}

	@Override
	public void updateAllowance(Allowance allowance, long id) {
		Allowance oldAllowance=allowanceRepository.findById(id).get();
		oldAllowance.setNightShiftDays(allowance.getNightShiftDays());
		oldAllowance.setAfternoonShiftDays(allowance.getAfternoonShiftDays());
		oldAllowance.setTADays(allowance.getTADays());
		allowanceRepository.save(oldAllowance);
	}

	@Override
	public void readData() {
		
	}

}
