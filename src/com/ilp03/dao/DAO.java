package com.ilp03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	public static Connection getConnection() {

		String connectionString = "jdbc:mysql://localhost:3306/sprint_planning_tool_db?useSSL=false";
		String userName = "root";
		String password = "root";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static ArrayList<Order> getAllOrders(Connection connection) {
//
//		Statement statement;
//		ArrayList<Order> orderList = new ArrayList<Order>();
//		try {
//			statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("select * from food_order");
//
//			while (resultSet.next()) {
//				int id = resultSet.getInt(1);
//				int foodId = resultSet.getInt(2);
//				String foodName = resultSet.getString(3);
//				int price = resultSet.getInt(4);
//				int quantity = resultSet.getInt(5);
//				int customerId = resultSet.getInt(6);
//
//				Order order = new Order(id, foodId, foodName, price, quantity, customerId);
//				orderList.add(order);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return orderList;
//
//	}
}
