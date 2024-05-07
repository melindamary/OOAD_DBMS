package com.ilp03.entity;

public class Project {

	private int projectId;
	private String projectName;
	private String createdDate;
	
	public Project(int projectId, String projectName, String createdDate) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.createdDate = createdDate;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
