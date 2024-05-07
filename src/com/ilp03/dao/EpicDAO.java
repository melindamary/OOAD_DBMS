package com.ilp03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EpicDAO {

	public static void addEpic() {
		Scanner scanner = new Scanner(System.in);
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(currentDate);
		try {
			Connection connection = DAO.getConnection();
			System.out.println("Enter name of project to add epic ");
			String projectName = scanner.next();
			PreparedStatement statement;
			
			String selectSql = " select backlog.backlog_id from project inner join backlog on project.project_id = backlog.project_id where project.project_name =?";
			statement = connection.prepareStatement(selectSql);
			statement.setString(1, projectName);
			ResultSet resultSet = statement.executeQuery();
			int backlogId;
			scanner.nextLine();
			System.out.println("Enter epic name: ");
			String epicName = scanner.nextLine();
			while(resultSet.next()){
				backlogId = resultSet.getInt(1);
				String insertSql = "insert into epic(backlog_id,epic_name,created_date) values(?,?,?)";
				statement = connection.prepareStatement(insertSql);

				statement.setInt(1, backlogId);
				statement.setString(2, epicName);
				statement.setString(3, formattedDate);
				statement.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
