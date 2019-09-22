package com.training.java.empApp.Service;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.training.java.empApp.Model.Employee;

public class EmployeeService implements Callable<Object>{
	  ArrayList<Employee> emplist=null;
	  
	public EmployeeService() {
	emplist = new ArrayList<Employee>();
	emplist.add(new Employee(1,"aaruni",22,"Oracle","Assoc","India"));
	emplist.add(new Employee(2,"ragini",19,"SAP","Assoc","UK"));
	emplist.add(new Employee(3,"himanshu",40,"FSD","CEO","Europe"));
	}
	public List<Employee> getList() {
		return emplist;
	}
	public static void add(ArrayList<Employee> emplist) throws IdAlreadyExists {
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
		
	   emplist.add(new Employee(id,name,age,dept,desgn,country));
		
		
	}
	
	public static void view(int id,ArrayList<Employee> emplist) throws NoIdFoundException{
	System.out.println("The details-");
	
		emplist.forEach(e->
		{
			if(((Employee) e).getEmpId()==id) {
						
			System.out.println(e.toString());}});
		
		
		}
		
	
	

	public static void viewAll(ArrayList<Employee> emplist) {
		System.out.println("Details of all Employees-");
		emplist.forEach(e->{
			System.out.println(e.toString());
		});
		
	}
	
	public static void delete(int id, ArrayList<Employee> emplist){
		try{Iterator<Employee> itr1 = emplist.iterator();

        while (itr1.hasNext()) {
            Employee e  = itr1.next();
            if(e.getEmpId()==id) {
            	itr1.remove();
            }
            else
            {
            	throw new NoIdFoundException();
            }
          }

		System.out.println("The required employee details have been deleted");
	}
		catch(NoIdFoundException e)
		{
			
		}
		
	}
	
	public static void update(int id, ArrayList<Employee> emplist) {
	try{Iterator<Employee> itr = emplist.iterator();

	int id1 = 0;
	while (itr.hasNext()) {
		
	    Employee e  = itr.next();
	    if(e.getEmpId()==id) {
	        id1 = id;
	    	itr.remove();
	    	
			           	
	    }
	    else
        {
        	throw new NoIdFoundException();
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
	emplist.add(new Employee(id1,name,age,dept,desgn,country));

	System.out.println("The required employee details have been updated");
	}
	catch(NoIdFoundException e)
	{
		
	}
	}
	
	public static void importEmployee(List empList) throws FileNotFoundException {
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
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	  }
