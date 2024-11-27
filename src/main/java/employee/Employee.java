package employee;

public class Employee 
{
	private int id;
	private String name;
	private double sal;
	private String address;
	
	public Employee()
	{	
	}
	
	
	public Employee(int id, String name, double sal, String address) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSal() {
		return sal;
	}


	public void setSal(double sal) {
		this.sal = sal;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + ", address=" + address + "]";
	}
	
	
	

}
