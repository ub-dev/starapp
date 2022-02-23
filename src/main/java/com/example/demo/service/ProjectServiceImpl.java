package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepository;

public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectRepository projectRepository;
	@Override
	public List<Project> getAllRoles() {
	return 	projectRepository.findAll();
	}
	

}
