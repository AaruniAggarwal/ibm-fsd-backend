package com.examples.empapp.controller;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.empapp.service.EmployeeService;

@WebServlet("/deleteEmployee.do")
public class DeleteEmployeeController extends HttpServlet{
 EmployeeService empService=new EmployeeService();
	
 
  
	public void init(ServletConfig config){
		System.out.println("Employee Deletion Servlet Initialized...");
	}

	@Override
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		empService.delete(empId);
		RequestDispatcher rd = request.getRequestDispatcher("listEmployees.do");
		rd.forward(request, response);
	}
	public void destroy(){
		System.out.println("Employee Deletion Servlet Destroyed...");		
	}


}
