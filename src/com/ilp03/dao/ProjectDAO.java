package com.ilp03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.ilp03.entity.Project;

public class ProjectDAO {

	public static void addProject() {
		Scanner scanner = new Scanner(System.in);
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(currentDate);
		try {
			Connection connection = DAO.getConnection();
			System.out.println("Enter Project Name");
			String projectName = scanner.nextLine();
			System.out.println("Enter Project Description");
			String description = scanner.nextLine();

			String insertSql = "insert into project(project_name,created_date,updated_date,description) values(?,?,?,?)";
//			String insertSql = "insert into project(project_name,created_date) values(?,?)";
			PreparedStatement statement = connection.prepareStatement(insertSql);

			statement.setString(1, projectName);
			statement.setString(2, formattedDate);
			statement.setString(3, formattedDate);
			statement.setString(4, description);
			statement.executeUpdate();

			String selectSql = "select project_id from project where project_name =? and created_date=?";
			statement = connection.prepareStatement(selectSql);
			statement.setString(1, projectName);
			statement.setString(2, formattedDate);
			ResultSet resultSet = statement.executeQuery();
			int projectId;
			while (resultSet.next()) {
				projectId = resultSet.getInt(1);
				insertSql = "insert into backlog(project_id,created_date) values(?,?)";
				statement = connection.prepareStatement(insertSql);

				statement.setInt(1, projectId);
				statement.setString(2, formattedDate);
				statement.executeUpdate();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Project> getProjects(Connection connection) {

		ArrayList<Project> projectList = new ArrayList<Project>();
		try {
			String selectSql = "Select project_id,project_name,created_date from project";
			PreparedStatement statement = connection.prepareStatement(selectSql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int projectId = resultSet.getInt(1);
				String projectName = resultSet.getString(2);
				String createdDate = resultSet.getString(3);
				Project project = new Project(projectId, projectName, createdDate);
				projectList.add(project);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projectList;
	}
}
