package com.ilp03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.ilp03.entity.Project;
import com.ilp03.entity.Sprint;

public class SprintDAO {

	public static void addSprint() {
		Scanner scanner = new Scanner(System.in);
		Connection connection = DAO.getConnection();
		PreparedStatement statement;

		try {
			System.out.println("Enter Project Name: ");
			String projectName = scanner.nextLine();

			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = dateFormat.format(currentDate);
			
			System.out.println("Enter Sprint start date: ");
			String date = scanner.nextLine();
			LocalDate startDate = LocalDate.parse(date);
			System.out.println("Enter Sprint end date: ");
			date = scanner.nextLine();
			LocalDate endDate = LocalDate.parse(date);

			System.out.println("Enter Sprint goal: ");
			String goal = scanner.nextLine();

			String selectSql = " select project_id from project where project_name = ?";

			statement = connection.prepareStatement(selectSql);
			statement.setString(1, projectName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int projectId = resultSet.getInt(1);

				String insertSql = "insert into sprint(project_id,start_date,end_date,goal,created_date) values(?,?,?,?,?)";
				statement = connection.prepareStatement(insertSql);
				statement.setInt(1, projectId);
				java.sql.Date sqlDate = java.sql.Date.valueOf(startDate);
				statement.setDate(2, sqlDate);
				sqlDate = java.sql.Date.valueOf(endDate);
				statement.setDate(3, sqlDate);
				statement.setString(4, goal);
				statement.setString(5, formattedDate);
				statement.executeUpdate();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Sprint> getSprints(Connection connection) {

		ArrayList<Sprint> sprintList = new ArrayList<Sprint>();
		try {
			System.out.println("Enter Project name: ");
			Scanner scanner = new Scanner(System.in);
			String projectName = scanner.nextLine();

			String selectSql = "select sprint.sprint_id, sprint.start_date, sprint.end_date, sprint.goal,"
					+ " sprint.created_date, project.project_id from sprint inner join project on"
					+ " sprint.project_id = project.project_id where project.project_name = ?";
			PreparedStatement statement = connection.prepareStatement(selectSql);
			statement.setString(1, projectName);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int sprintId = resultSet.getInt(1);
				Date startDate = resultSet.getDate(2);
				Date endDate = resultSet.getDate(3);
				String goal = resultSet.getString(4);
				String createdDate = resultSet.getString(5);
				int projectId = resultSet.getInt(6);
				Project project = new Project(projectId, projectName, createdDate);
				Sprint sprint = new Sprint(sprintId, startDate, endDate, goal, project);
				sprintList.add(sprint);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sprintList;
	}
	
}
