package com.example.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.model.Allowance;
import com.example.demo.repository.AllowanceRepository;
@Service
public class AllowanceServiceImpl implements AllowanceService{
	
	

	@Autowired
	AllowanceRepository allowanceRepository;
	
	@Override
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public List<Allowance> getAllAllowancesByProjectNameAndPeriod(String pname,String startdate,String enddate) throws ParseException {
		Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startdate);
		Date end = new SimpleDateFormat("yyyy-MM-dd").parse(enddate);

		List<Allowance> list = allowanceRepository.getProjectByNameAndPeriod(pname, start, end);
                  return list;
		}



	@Override
	public void readData() throws IOException {
		System.out.print("Reading...");
		File myFile=new File("C:\\Users\\utkarsh.bajpai\\OneDrive - Incedo Technology Solutions Ltd\\Desktop\\Projects\\Star\\starapp\\demo\\src\\main\\java\\timeSheet.xlsx");
		FileInputStream fis=new FileInputStream(myFile);
		try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet mySheet=workbook.getSheet("TimesheetComplaince");
			int r=mySheet.getLastRowNum();
			//int col=mySheet.getRow(1).getLastCellNum();
			for(int i=1;i<=r;i++)
			{
				int j=0;
				XSSFRow row=mySheet.getRow(i);
					Allowance allowance=new Allowance();
					allowance.setName(row.getCell(j++).getStringCellValue());
					allowance.setSAPId((long)row.getCell(j++).getNumericCellValue());
					allowance.setStartDate(row.getCell(j++).getDateCellValue());
					allowance.setEndDate(row.getCell(j++).getDateCellValue());
					allowance.setProjectHours((int)row.getCell(j).getNumericCellValue());
					allowance.setProjectName(row.getCell(13).getStringCellValue());
					allowance.setAfternoonShiftDays(allowance.getProjectHours()/8);
					allowance.setLeaveHours((allowance.getProjectHours())>=40?0:40-allowance.getProjectHours());
					allowance.setTADays(allowance.getAfternoonShiftDays());
					allowance.setNightShiftDays(allowance.getProjectHours()>=40?allowance.getProjectHours()-40:0);
					allowance.setTA(150*allowance.getTADays());
					allowance.setTotalAllowance(allowance.getTA()+(allowance.getNightShiftDays()*300));
					allowance.setStatus("Awaiting");
					if(!(allowance.getProjectName().equals("Leave_India") || allowance.getProjectName().equals("Holiday_India") ||allowance.getProjectName().equals("Leave_US") ))
					     allowanceRepository.save(allowance);
					j=0;
					
				
				}
		}
		
		System.out.println("Completed!");
	}

	public List<String> getDistinctProject() {
		return allowanceRepository.findDistinctProjectName();
	}

	public List<Allowance> getAllowancesByProjectName(String projectName) {
		return allowanceRepository.findAllByProjectName(projectName);
	}



	@Override
	public void updateAllowance(Allowance allowance) {
		Allowance oldAllowance = allowanceRepository.findById(allowance.getId()).orElseThrow(() -> new ResourceNotFoundException("User Allowance not found with id " + allowance.getId()));
		oldAllowance.setNightShiftDays(allowance.getNightShiftDays());
		oldAllowance.setAfternoonShiftDays(allowance.getAfternoonShiftDays());
		oldAllowance.setTADays(allowance.getTADays());
		double newTA = allowance.getTADays() * 150;
		double newShiftAllowance = allowance.getNightShiftDays() * 300;
		double newTotalAllowance = newTA + newShiftAllowance;
		oldAllowance.setTotalAllowance(newTotalAllowance);
		allowanceRepository.save(oldAllowance);
	
	}



	@Override
	public void updateAll(List<Allowance> list) {
		for(Allowance allowance:list)
		{
			allowance.setStatus("Approved");
		}
		allowanceRepository.saveAll(list);
	

	}
	
	

}
