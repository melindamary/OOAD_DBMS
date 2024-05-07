package com.ilp03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.ilp03.entity.Employee;
import com.ilp03.entity.UserStory;

public class UserStoryDAO {

	public static void addUserStory() {
		Scanner scanner = new Scanner(System.in);
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(currentDate);
		try {
			Connection connection = DAO.getConnection();
			System.out.println("Enter name of project");
			String projectName = scanner.nextLine();
			System.out.println("Enter name of epic to add user story ");
			String epicName = scanner.nextLine();

			PreparedStatement statement;

			String selectSql = " select epic.epic_id from epic inner join backlog on epic.backlog_id = backlog.backlog_id inner join project on project.project_id = backlog.project_id where project.project_name = ? and epic.epic_name = ?;";
			statement = connection.prepareStatement(selectSql);
			statement.setString(1, projectName);
			statement.setString(2, epicName);

			System.out.println("Enter email of employee to be assigned: ");
			String email = scanner.nextLine();
			String selectSql2 = "select employee_id from employee where email = ?";
			PreparedStatement statement2 = connection.prepareStatement(selectSql2);
			statement2.setString(1, email);
			int employeeId = 0;
			ResultSet resultSet2 = statement2.executeQuery();
			while(resultSet2.next()) {
				employeeId = resultSet2.getInt(1);
			}
			
			ResultSet resultSet = statement.executeQuery();
			int epicId;
			while (resultSet.next()) {
				epicId = resultSet.getInt(1);
				scanner.nextLine();
				System.out.println("Enter user story: ");
				String userStoryDesc = scanner.nextLine();
				String insertSql = "insert into user_story(epic_id,description,created_date,assignee_id) values(?,?,?,?)";
				statement = connection.prepareStatement(insertSql);

				statement.setInt(1, epicId);
				statement.setString(2, userStoryDesc);
				statement.setString(3, formattedDate);
				statement.setInt(4, employeeId);
				statement.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<UserStory> getUserStories(Connection connection) {

		ArrayList<UserStory> userStoryList = new ArrayList<UserStory>();
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nEnter Project name: ");
			String projectName = scanner.nextLine();

			String selectSql = " select user_story.epic_id, epic.epic_name,user_story.story_id,user_story.description,"
					+ "user_story.created_date,"
					+ "user_story.assignee_id, employee.employee_firstname,employee.employee_lastname, employee.email, user_story.status"
					+ " from user_story inner join employee on user_story.assignee_id = employee.employee_id inner join "
					+ " epic on user_story.epic_id = epic.epic_id"
					+ " inner join backlog on epic.backlog_id = backlog.backlog_id inner join project on backlog.project_id = project.project_id"
					+ " where project.project_name = ?;";
			PreparedStatement statement = connection.prepareStatement(selectSql);
			statement.setString(1, projectName);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int epicId = resultSet.getInt(1);
				String epicName = resultSet.getString(2);
				int storyId = resultSet.getInt(3);
				String userStoryDesc = resultSet.getString(4);
				String createdDate = resultSet.getString(5);
				int assignee_id = resultSet.getInt(6);
				String employee_firstname = resultSet.getString(7);
				String employee_lastname = resultSet.getString(8);
				String email = resultSet.getString(9);
				String status = resultSet.getString(10);
				Employee employee = new Employee(assignee_id,employee_firstname,employee_lastname,email);
				UserStory userStory = new UserStory(epicId, epicName, storyId, userStoryDesc, createdDate, status,employee);
				userStoryList.add(userStory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userStoryList;
	}
	
	public static void updateUserStory(int sprintId, int userStoryId ) {
		Scanner scanner = new Scanner(System.in);
		Connection connection = DAO.getConnection();
		PreparedStatement statement;

		try {
			String updateSql = " update user_story set sprint_id = ? where story_id = ?";

			statement = connection.prepareStatement(updateSql);
			statement.setInt(1, sprintId);
			statement.setInt(2, userStoryId);
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<UserStory> getUserStoriesInSprint(Connection connection) {

		ArrayList<UserStory> userStoriesInSprintList = new ArrayList<UserStory>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Sprint ID ");
		int sprintId = scanner.nextInt();		
		try {
			String selectSql = "select user_story.description, user_story.status, sprint.start_date, sprint.end_date, employee.email from employee inner join user_story on "
					+ "employee.employee_id = user_story.assignee_id inner join sprint on user_story.sprint_id = sprint.sprint_id where sprint.sprint_id = ?";
			PreparedStatement statement = connection.prepareStatement(selectSql);
			statement.setInt(1, sprintId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String description = resultSet.getString(1);
				String status = resultSet.getString(2);
				String startDate = resultSet.getString(3);
				String endDate = resultSet.getString(4);
				String email = resultSet.getString(5);
				Employee employee = new Employee(0,"","",email);
				UserStory story = new UserStory(0, null,0,description,null,status,employee);
				userStoriesInSprintList.add(story);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userStoriesInSprintList;
	}
	
}
