package com.ilp03.entity;

import java.time.LocalDate;
import java.util.Date;

public class Sprint {

	private int sprintId;
	private Date startDate;
	private Date endDate;
	private String goal;
	private Project project;

	public Sprint(int sprintId, Date startDate, Date endDate, String goal, Project project) {
		super();
		this.sprintId = sprintId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goal = goal;
		this.project = project;
	}

	public int getSprintId() {
		return sprintId;
	}

	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
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

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}
}
