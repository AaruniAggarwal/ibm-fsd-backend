package com.training.java.empapp.dao;

import java.sql.*;
import java.util.ArrayList;

import com.training.java.empapp.model.Employee;

 public class EmployeeDB 
 {  
  
	 Connection conn=null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	  	String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";
	  	String USER = "training";
		String PASS = "training";

    public void passingMsg(Employee e1) {
	  	
  try {
	     Class.forName("com.mysql.jdbc.Driver");
		 conn = DriverManager.getConnection(DB_URL, USER, PASS);
		 conn.setAutoCommit(true); // enable transaction

		//String str = "INSERT INTO employee (id,name, age,  department,designation, country) VALUES (12,'Anil', 30, 'Admin','Developer', 'India')";
		String sq = "INSERT INTO Employee (empId,name, age,dept,desgn,country)VALUES(?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sq);
            pstmt.setInt(1,e1.getEmpId());
            pstmt.setString(2,e1.getName());
            pstmt.setInt(3,e1.getAge());
            pstmt.setString(4,e1.getDept());
            pstmt.setString(5,e1.getDesgn());
            pstmt.setString(6,e1.getCountry());
        
		pstmt.executeQuery();
		conn.commit();
		System.out.println("Added succesfully.");
		conn.close();
  }
  catch(Exception e){
	e.printStackTrace(); 
  }
  }
    public void delete(int e) {
		try {
			System.out.println("Connecting...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(true);
			System.out.println("Connection Established: "+conn);
			
			System.out.println("Creating statement...");
			//stmt = conn.createStatement();
			
			String query1="delete from EmployeeData where id=?";
			pstmt=conn.prepareStatement(query1);
			pstmt.setInt(1, e);
			
			int deleteCount = pstmt.executeUpdate();
			pstmt.close();
			if(deleteCount<=0)
				System.out.println("Error in Deletion");
			System.out.println(deleteCount + " Employee(s) deleted");
			}
			catch (SQLException se) { // Handle errors for JDBC se.printStackTrace(); }
				se.printStackTrace();
		}
	}
    public void displayAll() {
		try {
			System.out.println("Connecting...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(true);
			System.out.println("Connection Established: "+conn);
			
			System.out.println("Creating statement...");
			
			
			String query1="select * from EmployeeData";
			pstmt=conn.prepareStatement(query1);
			
			rs = pstmt.executeQuery();
			
			System.out.println(rs + " Employee(s) displayed");
			
			ResultSetMetaData rsmeta = rs.getMetaData();
			int cols = rsmeta.getColumnCount();
			for(int i=1; i <= cols; i++) {
				System.out.print("\t" + rsmeta.getColumnName(i)+"|");
			}
			
         System.out.println();
			
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");

				// Display values
				System.out.format("\t%d | \t%s | \t%s | \t%s | \t%s |\n", id, name, designation, department, country);
			}
			
			pstmt.close();
			}
			catch (SQLException se) { // Handle errors for JDBC se.printStackTrace(); }
				se.printStackTrace();
		}
	}
    public void display(int e) {
		try {
			System.out.println("Connecting...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(true);
			System.out.println("Connection Established: "+conn);
			
			System.out.println("Creating statement...");
			//stmt = conn.createStatement();
			
			String query1="select * from EmployeeData where id=?";
			pstmt=conn.prepareStatement(query1);
			pstmt.setInt(1, e);
			
			rs = pstmt.executeQuery();
			//if(rs<0)
				//System.out.println("Error in selection");
			System.out.println(rs + " Employee(s) displayed");
			
			ResultSetMetaData rsmeta = rs.getMetaData();
			int cols = rsmeta.getColumnCount();
			for(int i=1; i <= cols; i++) {
				System.out.print("\t" + rsmeta.getColumnName(i)+"|");
			}
			
System.out.println();
			
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");

				// Display values
				System.out.format("\t%d | \t%s | \t%s | \t%s | \t%s |\n", id, name, designation, department, country);
			}
			
			pstmt.close();
			}
			catch (SQLException se) { // Handle errors for JDBC se.printStackTrace(); }
				se.printStackTrace();
		}
	}
	
    public void update(int id, Employee e1) {
		try {
			System.out.println("Connecting...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(true);
			System.out.println("Connection Established: "+conn);
			
			System.out.println("Creating statement...");
			//stmt = conn.createStatement();
			
			String query1="update EmployeeData set id=?,name=?,designation=?,department=?,country=? where id=? ";
			pstmt=conn.prepareStatement(query1);
			pstmt.setInt(1, e1.getEmpId());
			pstmt.setString(2,e1.getName());
			pstmt.setInt(3,e1.getAge());
			pstmt.setString(4, e1.getDept());
			pstmt.setString(5, e1.getDesgn());
			pstmt.setString(6, e1.getCountry());
			pstmt.setInt(6, id);
			
			int insertCount = pstmt.executeUpdate();
			pstmt.close();
			System.out.println(insertCount + " Employee(s) u");
			}
			catch (SQLException se) { // Handle errors for JDBC se.printStackTrace(); }
				se.printStackTrace();
		}
	}
     public ArrayList<Employee> export() {
		try {
			ArrayList<Employee> empList=new ArrayList<Employee>();
			System.out.println("Connecting...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(true);
			System.out.println("Connection Established: "+conn);
			
			System.out.println("Creating statement...");
			//stmt = conn.createStatement();
			
			String query1="select * from EmployeeData";
			pstmt=conn.prepareStatement(query1);
			
			rs = pstmt.executeQuery();
			//if(rs<0)
				//System.out.println("Error in selection");
			System.out.println(rs + " Employee(s) displayed");
			
			ResultSetMetaData rsmeta = rs.getMetaData();
			int cols = rsmeta.getColumnCount();
			for(int i=1; i <= cols; i++) {
				System.out.print("\t" + rsmeta.getColumnName(i)+"|");
			}
			
System.out.println();
			
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");
				empList.add(new Employee(id,name,age,department,desgn,country));
				// Display values
				//System.out.format("\t%d | \t%s | \t%s | \t%s | \t%s |\n", id, name, designation, department, country);
				
			}
			
			pstmt.close();
			return empList;
			}
			catch (SQLException se) { // Handle errors for JDBC se.printStackTrace(); }
				se.printStackTrace();
		}
		return null;

	}


	
}

