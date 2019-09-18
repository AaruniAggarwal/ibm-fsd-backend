package com.training.java.empApp.Main;
import java.io.*;
import java.util.*;

import com.training.java.empApp.Model.Employee;
import com.training.java.empApp.Service.EmployeeService;
public class EmployeeMain extends EmployeeService {

public static void main(String[] args) throws IOException {
	
	// TODO Auto-generated method stub
	ArrayList<Employee> emplist = new ArrayList<Employee>();
	emplist.add(new Employee(1,"aaruni",22,"Oracle","Assoc","India"));
	emplist.add(new Employee(2,"ragini",19,"SAP","Assoc","UK"));
	emplist.add(new Employee(3,"himanshu",40,"FSD","CEO","Europe"));
	


	int option = 0;
	
	while(option!=8) {
	System.out.println("Menu -");
	System.out.println("1- Add Employee\n2- View Employee\n3- Update Employee\n4- Delete Employee\n5- View All Employees\n6- Import");
	System.out.print("7- Exit\nEnter Your Option-");
	Scanner sc = new Scanner(System.in);
	option = sc.nextInt();
	
	if(option==1) {
		add(emplist);
	}
	
	if(option==2) {
		System.out.print("Enter the empId-");
		int id = sc.nextInt();
		view(id,emplist);
	}
	
	if(option==3) {
		System.out.print("Enter the empId-");
		int id = sc.nextInt();
		update(id,emplist);
	}
	
	if(option==4) {
		System.out.print("Enter the empId-");
		int id = sc.nextInt();
		delete(id,emplist);
	}
	
	if(option==5) {
		viewAll(emplist);
	}
	if(option==6) {
		
			        Employee e2 = importEmployee();
			        emplist.add(e2);


	}
	if(option==7) {

			DataOutputStream out = null;
			FileWriter writer=null;
			try {
				 writer = new FileWriter("C:\\temporary\\output.txt");
				for(Employee str: emplist) {
				  writer.write(str + System.lineSeparator());
				}
					
								
			} 
			catch (NullPointerException e) 
			{
			   }
			finally 
			{
				writer.close();
			}
}

}


}


}

