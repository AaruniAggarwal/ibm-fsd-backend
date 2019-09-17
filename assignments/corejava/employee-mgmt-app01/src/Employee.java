
public class Employee<T extends Number> extends Person{

	private int empId;
	private String designation;
	private String department;
	private T salary;

	public Employee() {
		System.out.println("Employee class default constructor");
	}

	public Employee(int empId, String name, int age, String gender, String designation, String department, T salary) {
		super(name, age, gender);
		this.empId = empId;
		this.designation = designation;
		this.department = department;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public T getSalary() {
		return salary;
	}

	public void setSalary(T salary) {
		this.salary = salary;
	}

	@Override
	protected void printDetails() {
		// print employee details
		System.out.println("Print employee details");
		System.out.println("EmpId: " + this.getEmpId());
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Designation: " + this.getDesignation());
		System.out.println("Department: " + this.getDepartment());
		System.out.println("Salary: " + this.getSalary());
		System.out.println();
	}

	public static void sayHello() {
		System.out.println("Hello Employee \n");
	}

	

	@Override
	public int hashCode() {
		return this.getEmpId() % 5;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			return this.getEmpId() == ((Employee) obj).getEmpId();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId+ ", name= "+String.valueOf(this.getName())+", Age="+String.valueOf(this.getAge())+ ", designation=" + designation + ", department=" + department + ", salary="
				+ salary + "]";
	}

	
}


