package com.examples.empapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;

import javax.servlet.http.*;
@WebServlet("/addEmployee.do")
public class EmployeeController extends HttpServlet {

	//EmployeeService empService = new EmployeeService();
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Initialized...");
	}
	public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException
	{
		System.out.println("Calling GET method");
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws IOException
	{
		 try {
		 EmployeeService empService=new EmployeeService();
		HttpSession session = request.getSession();
		
		
		System.out.println("Session ID: " + session.getId());
		
//		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String department = request.getParameter("department");
		String designation = request.getParameter("designation");
		String country = request.getParameter("country");
		
//		session.setAttribute("id", id);
//		session.setAttribute("name", name);
//		session.setAttribute("age", age);
//		session.setAttribute("department", department);
//		session.setAttribute("designation", designation);
//		session.setAttribute("country", country);
  
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Designation: " + designation);
		System.out.println("Departememt: " + department);
		System.out.println("Country: " + country);	
		Employee emp = new Employee();
		emp.setName(name);
		emp.setAge(age);
		emp.setDesignation(designation);
		emp.setDepartment(department);
		emp.setCountry(country);
		
		empService.create(emp);
		
		System.out.println("Employee created successfully.");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><body>");
		out.print("<p>Employee Addition Successful.</p>");
		
		out.println("<p>empName: " + name + "</p>");
		out.println("<p>empAge: " + age + "</p>");
		out.println("<p>empDept: " + department + "</p>");
		out.println("<p>empDesign: " + designation + "</p>");
		out.println("<p>empCountry: " + country + "</p>");		
		out.println("<a href='index.jsp'>home</a>");
		out.println("</body></html>");
		RequestDispatcher rd = request.getRequestDispatcher("listEmployees.do");
		rd.forward(request, response);
		
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
	}
			
	public void destroy()
	{
		System.out.println("EmployeeAddition Servlet Destroyed...");		
	}



}
