package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Allowance;

@Repository
public interface AllowanceRepository extends JpaRepository<Allowance, Long> {
	public ArrayList<Allowance> findAllByProjectName(String projectname);

	@Query(value = "select distinct  project_name from allowance", nativeQuery = true)
	public ArrayList<String> findDistinctByProjectName();

	@Query(value = "select * from allowance where project_name=?1 and start_date=?2 and end_date=?3", nativeQuery = true)
	public List<Allowance> getProjectNameAndPeriod(String projectName, Date startDate, Date endDate);
}
