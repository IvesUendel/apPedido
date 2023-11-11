package br.com.apPedido.model.domain;

public class Seller extends User{

	private int employee_code;
	private double salary;
	private double comission;
	
	protected Seller() {}
	
	public Seller(String name, String address, String email) {
		super(name, address, email);
	}
	
	public Seller(String name, String address, String email, int employee_code, double salary, double comission) {
		super(name, address, email);
		this.employee_code = employee_code;
		this.salary = salary;
		this.comission = comission;
	}

	public int getEmployee_code() {
		return employee_code;
	}

	public void setEmployee_code(int employee_code) {
		this.employee_code = employee_code;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getComission() {
		return comission;
	}

	public void setComission(double comission) {
		this.comission = comission;
	}
	
}
