
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EmployeeMain {

	public static void main(String[] args) {

		Map<Integer, Employee<Double>> employees = new TreeMap<>();

		employees.put(100, new Employee<Double>(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000.0));
		employees.put(101, new Employee<Double>(101, "Mukesh", 25, "Male", "Developer", "CSE", 20000.0));
		employees.put(102, new Employee<Double>(102, "Jancy", 30, "Female", "Sr.Developer", "IT", 30000.0));
		employees.put(103, new Employee<Double>(103, "John", 28, "Male", "Developer", "ECE", 40000.0));
		employees.put(104, new Employee<Double>(104, "Mathew", 30, "Male", "Developer", "IT", 60000.0));
		employees.put(105, new Employee<Double>(105, "Mary", 27, "Female", "Sr.Developer", "CSE", 70000.0));
		
		System.out.println("1: add an employee");
		System.out.println("2: view an employee ");
		System.out.println("3: delete an employee ");
		System.out.println("4: view all employees ");
		System.out.println("5: update an employee ");
		System.out.println("enter option:");
		
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);
		int option=myObj.nextInt();
		
		int id;
		
		switch(option) {
		
		case 1:
			employees.put(106, new Employee<Double>(106, "Anand", 35, "Male", "Sr.Developer", "IT", 50000.0));
			break;
			
		case 2:
			System.out.println("enter employee id of employee to be shown:");
			id=myObj.nextInt();
			System.out.println(employees.get(id));
			break;
			
		case 3:
			System.out.println("enter employee id of employee to be deleted:");
			id=myObj.nextInt();
			employees.remove(id);
			break;
			
		case 4:
			List<Employee<Double>> emp1 = new ArrayList<>(employees.values());
			for (Employee<Double> empl : emp1) {
				System.out.println(empl);
			}
			break;
			
		case 5:
			System.out.println("enter employee id of employee to be updated:");
			id=myObj.nextInt();
			//List<Employee<Double>> emp2 = new ArrayList<>(employees.values());
			System.out.println("enter name:");
			String name=myObj.next();
			Employee e=employees.get(id);
			e.setName(name);
			break;
			
		}
	}

}

