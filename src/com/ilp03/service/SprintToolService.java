package com.ilp03.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp03.dao.DAO;
import com.ilp03.dao.ProjectDAO;
import com.ilp03.dao.SprintDAO;
import com.ilp03.dao.UserStoryDAO;
import com.ilp03.entity.Project;
import com.ilp03.entity.Sprint;
import com.ilp03.entity.UserStory;

public class SprintToolService {

	public static void displayProjects() {
		try {
			Connection connection = DAO.getConnection();
			ArrayList<Project> projectList = ProjectDAO.getProjects(connection);
			System.out.println("----------------------------------------------------------");
			System.out.printf("%-30s %s\n", "Project Name", "Created Date");
			System.out.println("----------------------------------------------------------");
			for (Project project : projectList) {
			    System.out.printf("%-30s %s\n", project.getProjectName(), project.getCreatedDate());
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void displayUserStories() {
		try {
			Scanner scanner = new Scanner(System.in);
			Connection connection = DAO.getConnection();
			ArrayList<UserStory> userStoryList = UserStoryDAO.getUserStories(connection);
			System.out.println("----------------------------------------------------------------------------------------------------------------------");
			System.out.printf("| %-15s | %-20s | %-15s | %-25s | %-50s |\n", "User Story ID", "Epic Name", "Created Date", "Assigned Email", "User Story");
			System.out.println("----------------------------------------------------------------------------------------------------------------------");
			for (UserStory userStory : userStoryList) {
			    System.out.printf("| %-15s | %-20s | %-15s | %-25s | %-50s |\n", userStory.getStoryId(), userStory.getEpicName(), userStory.getCreatedDate(), userStory.getEmployee().getEmail(), userStory.getDescription());
			}
			System.out.println("----------------------------------------------------------------------------------------------------------------------");


			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addStoryToSprint() {
		Connection connection = DAO.getConnection();
		Scanner scanner = new Scanner(System.in);
		ArrayList<Sprint> sprintList = SprintDAO.getSprints(connection);
		System.out.println("\n--------------------------Sprints for selected project-------------------------");
		System.out.printf("%-10s %-12s %-15s %-50s\n", "Sprint ID", "Start Date", "End Date", "Sprint Goal");
		System.out.println("-------------------------------------------------------------------------------");
		for(Sprint sprint: sprintList) {
		    System.out.printf("%-10s %-12s %-15s %-50s\n", sprint.getSprintId(), sprint.getStartDate(), sprint.getEndDate(), sprint.getGoal());
		}

		displayUserStories();
		System.out.println("\nEnter Sprint ID to which the user story is to be added: ");
		int sprintId = scanner.nextInt();
		System.out.println("Enter user story ID to be added: ");
		int userStoryId = scanner.nextInt();
		UserStoryDAO.updateUserStory(sprintId, userStoryId);
	}
	
	public static void viewUserStoriesInSprint() {
		Connection connection = DAO.getConnection();
		ArrayList<UserStory> userStoryInSprintList = UserStoryDAO.getUserStoriesInSprint(connection);
		System.out.println("------------------------------User Stories in Selected Sprint-------------------------\n");
		System.out.printf("%-50s | %-15s | %-20s\n", "User Story", "Status", "Assignee Email");
		System.out.println("--------------------------------------------------------------------------------------");
		for(UserStory story: userStoryInSprintList) {
		    System.out.printf("%-50s | %-15s | %-20s\n", story.getDescription(), story.getStatus(), story.getEmployee().getEmail());
		}

	}
}
