package com.ilp03.entity;

public class Epic {

	private int epicId;
	private String epicName;
	
	
	public Epic(int epicId, String epicName) {
		super();
		this.epicId = epicId;
		this.epicName = epicName;
	}
	
	public int getEpicId() {
		return epicId;
	}
	public void setEpicId(int epicId) {
		this.epicId = epicId;
	}
	public String getEpicName() {
		return epicName;
	}
	public void setEpicName(String epicName) {
		this.epicName = epicName;
	}
	
	
}
