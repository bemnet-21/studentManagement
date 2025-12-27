package com.learn.controller;

import java.io.IOException;
import java.util.List;

import com.learn.dao.StudentDAO;
import com.learn.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/register", "/show_all"})
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;
	
	public void init() {
		studentDAO = new StudentDAO();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch(action) {
		case "/show_all":
			listStudents(req, res);
			break;
		default:
			showRegisterForm(req, res);
			break;
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action.equals("/register")) {
			registerStudent(req, res);
		}
	}
	
	private void listStudents(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Student> listStudents = studentDAO.selectAllStudents();
		
		req.setAttribute("listStudents", listStudents);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("student-list.jsp");
		dispatcher.forward(req, res);
	}
	
	private void showRegisterForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, res);
	}
	
	private void registerStudent(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		int year = Integer.parseInt(req.getParameter("year"));
		
		Student newStudent = new Student(name, email, year);
		
		studentDAO.insertStudents(newStudent);
		res.sendRedirect("show_all");
	}
	
	
}
	
	
