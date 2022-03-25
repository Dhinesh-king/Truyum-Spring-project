package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	static Connection conn = null;
	static Properties props = new Properties();

	private ConnectionHandler() {
		super();
	}

	/**
	 * static getConnection(): Connection 1. Using java.io.FileInputStream and
	 * java.util.Properties read the properties from connection.properties file. 2.
	 * Gets connection using ConnectionManager based on properties from previous
	 * step and return the connection.
	 */
	public static Connection getConnection() {
		try (FileInputStream fis = new FileInputStream("src/main/java/connection.properties")) {
			props.load(fis);
			Class.forName(props.getProperty("driver"));
			conn = DriverManager.getConnection(props.getProperty("connection-url"), props.getProperty("user"),
					props.getProperty("password"));
		} catch (SQLException | IOException e) {
			System.out.println("SQL or Input/Output Exception is thrown...");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("The Given Class could not be found for Sql Driver...");
			e.printStackTrace();
		}
		return conn;

	}
}
