package br.com.apPedido.model.domain;

import jakarta.persistence.Entity;

@Entity
public class LegalCustomer extends User{

	private int cnpj;
	
	public LegalCustomer() {}
	
	public LegalCustomer(String name, String address, String email) {
		super(name, address, email);
	}
	
	public LegalCustomer(String name, String address, String email, int cnpj) {
		super(name, address, email);
		this.cnpj = cnpj;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
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
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s - CNPJ: (%d)", super.toString(), cnpj);	
	}

}
