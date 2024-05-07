package com.ilp03.entity;

public class UserStory extends Epic{

	private int storyId;
	private String description;
	private String createdDate;
	private String status;
	private Employee employee;
	
	public UserStory(int epicId, String epicName, int storyId, String description, String createdDate, String status, Employee employee) {
		super(epicId, epicName);
		this.storyId = storyId;
		this.description = description;
		this.createdDate = createdDate;
		this.status = status;
		this.employee = employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getStoryId() {
		return storyId;
	}
	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
