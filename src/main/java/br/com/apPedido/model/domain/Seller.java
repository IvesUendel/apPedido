package br.com.apPedido.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Seller extends User{

	private int employee_code;
	private double salary;
	private double comission;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idAddress")
	private Address brazilAddress;
	
	public Seller() {}
	
	public Seller(String name, String address, String email, int employee_code, double salary, double comission) {
		super(name, address, email);
		this.employee_code = employee_code;
		this.salary = salary;
		this.comission = comission;
	}
	
	public Seller(String name, String address, String email, int employee_code, double salary, double comission, Address brazilAddress) {
		super(name, address, email);
		this.employee_code = employee_code;
		this.salary = salary;
		this.comission = comission;
		this.brazilAddress = brazilAddress;
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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return super.getAddress();
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		super.setAddress(address);
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}
	
	@Override
	public Address getBrazilAddress() {
		// TODO Auto-generated method stub
		return super.getBrazilAddress();
	}

	@Override
	public void setBrazilAddress(Address brazilAddress) {
		// TODO Auto-generated method stub
		super.setBrazilAddress(brazilAddress);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s - Employee Code: (%d) - Salary: (%.2f) - Comission: (%.2f)", super.toString(), employee_code, salary, comission);
	}
	
}
