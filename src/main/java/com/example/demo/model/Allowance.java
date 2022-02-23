package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="allowance")
public class Allowance {
	
	private String name;
	@Id
	private long SAPId;
	private int projectHours;
	private LocalDate startDate;
	private LocalDate endDate;
	private int leaveHours;
	private int afternoonShiftDays;
	private int nightShiftDays;
	private int TADays;
	private double TA;
	private double totalAllowance;
	private String status;
	private String projectName;
	
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable( name="allowance_project", joinColumns = @JoinColumn(name="SAPId",
	 * referencedColumnName="SAPId"), inverseJoinColumns = @JoinColumn(name=
	 * "project_id", referencedColumnName="id")
	 * 
	 * ) private List<Project> project=new ArrayList<>();
	 */
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSAPId() {
		return SAPId;
	}
	public void setSAPId(long sAPId) {
		SAPId = sAPId;
	}
	public int getProjectHours() {
		return projectHours;
	}
	public void setProjectHours(int projectHours) {
		this.projectHours = projectHours;
	}
	public int getLeaveHours() {
		return leaveHours;
	}
	public void setLeaveHours(int leaveHours) {
		this.leaveHours = leaveHours;
	}
	public int getAfternoonShiftDays() {
		return afternoonShiftDays;
	}
	public void setAfternoonShiftDays(int afternoonShiftDays) {
		this.afternoonShiftDays = afternoonShiftDays;
	}
	public int getNightShiftDays() {
		return nightShiftDays;
	}
	public void setNightShiftDays(int nightShiftDays) {
		this.nightShiftDays = nightShiftDays;
	}
	public int getTADays() {
		return TADays;
	}
	public void setTADays(int tADays) {
		TADays = tADays;
	}
	public double getTA() {
		return TA;
	}
	public void setTA(double tA) {
		TA = tA;
	}
	public double getTotalAllowance() {
		return totalAllowance;
	}
	public void setTotalAllowance(double totalAllowance) {
		this.totalAllowance = totalAllowance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Allowance(String name, long sAPId, int projectHours, LocalDate startDate, LocalDate endDate, int leaveHours,
			int afternoonShiftDays, int nightShiftDays, int tADays, double tA, double totalAllowance, String status,
			String projectName) {
		super();
		this.name = name;
		SAPId = sAPId;
		this.projectHours = projectHours;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaveHours = leaveHours;
		this.afternoonShiftDays = afternoonShiftDays;
		this.nightShiftDays = nightShiftDays;
		TADays = tADays;
		TA = tA;
		this.totalAllowance = totalAllowance;
		this.status = status;
		this.projectName = projectName;
	}
	public Allowance()
	{
		
	}

}
