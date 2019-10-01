package com.examples.empapp.service;
import com.examples.empapp.configuration.EmployeeBeanConfiguration;
//import com.examples.empapp.dao.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.examples.empapp.model.Employee;
import com.examples.empapp.dao.EmployeeDB;
public class EmployeeService implements Callable<Object>{
	  ArrayList<Employee> emplist=null;
	   AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeBeanConfiguration.class);
		public  EmployeeDB empdb = (EmployeeDB)context.getBean("empDao");
	   

	  //static EmployeeDB empdb=new EmployeeDB();
	public EmployeeService() {
	emplist = new ArrayList<Employee>();
	emplist.add(new Employee(1,"aaruni",22,"Oracle","Assoc","India"));
	emplist.add(new Employee(2,"ragini",19,"SAP","Assoc","UK"));
	emplist.add(new Employee(3,"himanshu",40,"FSD","CEO","Europe"));
	}
	public List<Employee> getList() {
		return emplist;
	}
	public void add(ArrayList<Employee> emplist) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter empId-");
		int id=sc.nextInt();
		System.out.print("Enter name-");
		String name = sc.next();
		System.out.print("Enter age-");
		int age = sc.nextInt();
		System.out.print("Enter dept-");
		String dept = sc.next();
		System.out.print("Enter desgn-");
		String desgn = sc.next();
		System.out.print("Enter country-");
		String country = sc.next();
		Employee emp1=new Employee(id,name,age,dept,desgn,country);
		emplist.add(emp1);
		
		empdb.passingMsg(emp1);
		sc.close();
		
	}
	
	public void view(int id,ArrayList<Employee> emplist) {
		System.out.println("The details-");
		emplist.forEach(e->
		{if(((Employee) e).getEmpId()==id) {
						
			System.out.println(e.toString());}});
		     empdb.display(id);
		
	}
	
	public void viewAll(ArrayList<Employee> emplist) {
		System.out.println("Details of all Employees-");
		emplist.forEach(e->{
			System.out.println(e.toString());
		});
		empdb.displayAll();
	}
	
	public void delete(int id, ArrayList<Employee> emplist) {
		
		Iterator<Employee> itr1 = emplist.iterator();

      while (itr1.hasNext()) {
          Employee e  = itr1.next();
          if(e.getEmpId()==id) {
          	itr1.remove();
          }
        }

		System.out.println("The required employee details have been deleted");
		empdb.delete(id);			
	}
	
	public void update(int id, ArrayList<Employee> emplist) {
		
		Iterator<Employee> itr = emplist.iterator();

      int id1 = 0;
      while (itr.hasNext()) {
      	
          Employee e  = itr.next();
          if(e.getEmpId()==id) {
              id1 = id;
          	itr.remove();
          	
      		           	
          }
        }
      Scanner sc = new Scanner(System.in);
		System.out.print("Enter modified name-");
		String name = sc.next();
		System.out.print("Enter modified age-");
		int age = sc.nextInt();
		System.out.print("Enter modified dept-");
		String dept = sc.next();
		System.out.print("Enter modified desgn-");
		String desgn = sc.next();
		System.out.print("Enter modified country-");
		String country = sc.next();
		Employee e2=new Employee(id1,name,age,dept,desgn,country);
   	emplist.add(e2);
		System.out.println("The required employee details have been updated");
		empdb.update(id1,e2);	
		sc.close();
	}
	public void importEmployee(ArrayList<Employee> empList) throws FileNotFoundException {
		Scanner input=null;
		try { 
			Employee e2=null;
		
		  input = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream
				 ("C:\\temporary\\input.txt"))));
		    input.useDelimiter(",|\n");

		    
		    while(input.hasNext()) {
		        int id = input.nextInt();
		        String name = input.next();
		        int age = input.nextInt();
		        String department = input.next();
		        String desgn = input.next();			        
		        String country = input.next();

		        e2 = new Employee(id,name, age, department, desgn, country);
		        empList.add(e2);
		    }
	
	}
	finally {
		if (input != null) {
        input.close();
      }
	}
	
	
	}
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	}
