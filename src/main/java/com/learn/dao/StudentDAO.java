package com.learn.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.learn.model.Student;

public class StudentDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	
	public StudentDAO() {
		loadDbProperties();
	}
	
	private void loadDbProperties() {
		Properties prop = new Properties();
		try ( InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
		
			if (input == null) {
				System.out.println("Sorry, unable to find db.properties");
				return;
			}
			
			prop.load(input);
			
			this.jdbcURL = prop.getProperty("db.url");
			this.jdbcUsername = prop.getProperty("db.username");
			this.jdbcPassword = prop.getProperty("db.password");
	} catch( Exception e ) {
		e.printStackTrace();
	}
		
}
	
	protected Connection getConnection() {
	    Connection connection = null;

	    try {
	        Class.forName("org.postgresql.Driver");
	      
	        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return connection;
	}
	
	public void insertStudents(Student student) {
		String INSERT = "INSERT INTO students (name, email, year) VALUES (?, ?, ?)";
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
			
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getEmail());
			preparedStatement.setInt(3, student.getYear());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> selectAllStudents() {
		List<Student> students = new ArrayList<>();
		String SELECT = "SELECT * FROM students";
		
		try ( Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
				ResultSet rs = preparedStatement.executeQuery()) {
			while(rs.next()) {
				Student student = new Student();
				
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setYear(rs.getInt("year"));
				
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}
}
	
