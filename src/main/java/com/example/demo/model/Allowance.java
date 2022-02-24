package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="allowance")
public class Allowance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	public long getId() {
		return id;
	}
	private long SAPId;
	private String name;
	private int projectHours;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@ColumnDefault("0")
	private int leaveHours;
	private int afternoonShiftDays;
	@ColumnDefault("0")
	private int nightShiftDays;
	private int TADays;
	private double TA;
	private double totalAllowance;
	private String status;
	private String projectName;



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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Allowance(String name, long sAPId, int projectHours, Date startDate, Date endDate, int leaveHours,
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
