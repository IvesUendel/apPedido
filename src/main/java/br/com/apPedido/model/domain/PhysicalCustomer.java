package br.com.apPedido.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PhysicalCustomer extends User{

	private int cpf;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idAddress")
	private Address brazilAddress;
	
	public PhysicalCustomer() {}
	
	public PhysicalCustomer(String name, String address, String email, int cpf) {
		super(name, address, email);
		this.cpf = cpf;
	}
	
	public PhysicalCustomer(String name, String address, String email, int cpf, Address brazilAddress) {
		super(name, address, email);
		this.cpf = cpf;
		this.brazilAddress = brazilAddress;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
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
		return String.format("%s - CPF: (%d)", super.toString(), cpf);
	}
		
}
