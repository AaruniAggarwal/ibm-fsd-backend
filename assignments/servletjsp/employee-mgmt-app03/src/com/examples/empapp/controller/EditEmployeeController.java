package com.examples.empapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;

@WebServlet("/editEmployee.do")
public class EditEmployeeController extends HttpServlet{

EmployeeService empService = new EmployeeService();
	String id;
	@Override
	public void init(ServletConfig config){
		System.out.println("Employee Updation Servlet Initialized...");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		id=req.getParameter("empId");
		RequestDispatcher rd= req.getRequestDispatcher("editEmployee.jsp");
		rd.forward(req, resp);
		this.doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session = request.getSession();
		int empId = Integer.parseInt(id);
//		int empId = Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		int empAge=Integer.parseInt(request.getParameter("empAge"));
		String empDept = request.getParameter("empDept");
		String empDesign = request.getParameter("empDesign");
		String empCountry = request.getParameter("empCountry");
		
//		request.getSession(false).getAttribute("empName");
//		request.getSession(false).getAttribute("empAge");
//		request.getSession(false).getAttribute("empDept");
//		request.getSession(false).getAttribute("empDesign");
//		request.getSession(false).getAttribute("empCountry");
		
		System.out.println("Id: " + empId);
		System.out.println("Name: " + empName);
		System.out.println("Age: " + empAge);
		System.out.println("Designation: " + empDept);
		System.out.println("Departememt: " + empDesign);
		System.out.println("Country: " + empCountry);
		if(empService.get(empId).getEmpId()==empId) {
			Employee newEmp = new Employee(empId, empName, empAge, empDept, empDesign, empCountry);
			empService.update(newEmp);
			System.out.println("Employee updated successfully.");
			
			RequestDispatcher rd2 = request.getRequestDispatcher("listEmployees.do");
			rd2.forward(request, response);
						
		}else {
			System.out.println("given empId doesn't exist");
		}
			
		
	}
	public void destroy(){
		System.out.println("Employee Updation Servlet Destroyed...");		
	}
	

}



