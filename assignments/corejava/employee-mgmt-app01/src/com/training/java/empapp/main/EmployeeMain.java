package com.training.java.empapp.main;

import java.io.*;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.training.java.empapp.service.*;
import com.training.java.empapp.model.Employee;
import com.training.java.empapp.service.EmployeeService;
import com.training.java.empapp.service.IdAlreadyExists;
import com.training.java.empapp.service.NoIdFoundException;
public class EmployeeMain extends EmployeeService {

public static void main(String[] args) throws IOException, NoIdFoundException, IdAlreadyExists {
	
   EmployeeService empserv=new EmployeeService();
   //empserv.getArrayList();
   ArrayList<Employee>emplist1=(ArrayList<Employee>) empserv.getList();
   try {
	    int option = 0;
	
	do {
	System.out.println("Menu -");
	System.out.println("1- Add Employee\n2- View Employee\n3- Update Employee\n4- Delete Employee\n5- View All Employees\n6- Import");
	System.out.print("7- Export \n 8- Exit \n Enter Your Option-");
	Scanner sc = new Scanner(System.in);
	option = sc.nextInt();
	
	if(option==1) {
		
		add(emplist1);
		
		
	}
	
	if(option==2) {
		System.out.print("Enter the empId-");
		int id = sc.nextInt();
		
			view(id,emplist1);
			
		
		
	}
	
	if(option==3) {
		System.out.print("Enter the empId-");
		int id = sc.nextInt();
		
		update(id,emplist1);
		
		
	}
	
	if(option==4) {
		System.out.print("Enter the empId-");
		int id = sc.nextInt();
		
			delete(id,emplist1);
		
	}
	
	if(option==5) {
		viewAll(emplist1);
	}
	if(option==6) {
		
//		Callable<Object> c1 = (Callable<Object>) EmployeeService.importEmployee(emplist1);
//			        // importEmployee(emplist);
//			        
//		ExecutorService e = Executors.newFixedThreadPool(2);
//
//		Future<String> f = e.submit(c1);
//		while(!f.isDone()) {
//			System.out.println(Thread.currentThread().getName() + " -->Wait");
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e1) {
//				e1.printStackTrace();
//			}
//		}
//
//	}
		ExecutorService e= Executors.newFixedThreadPool(7);
		Future<Boolean> f=e.submit(new Callable<Boolean>() {
				public Boolean call() throws RuntimeException, IOException {
					System.out.print("Thread : "+Thread.currentThread().getName());
					importEmployee(emplist1);
					return true;
				}
			});
			e.shutdown();
			
	}
	if(option==7) {

//			
		ExecutorService e2= Executors.newFixedThreadPool(7);
		Future<Boolean> f2=e2.submit(new Callable<Boolean>() {
				public Boolean call() throws IOException {
					System.out.print("Thread : "+Thread.currentThread().getName());
					DataOutputStream out = null;
					FileWriter writer=null;
					try {
						 writer = new FileWriter("C:\\temporary\\output.txt");
						for(Employee str: emplist1) {
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
					return true;
				}
			});
		e2.shutdown();
			break;
}

}while(option!=9);
   }
   catch(InputMismatchException e) {
		System.out.println("Error...Enter a number");
	}
   

}


}

