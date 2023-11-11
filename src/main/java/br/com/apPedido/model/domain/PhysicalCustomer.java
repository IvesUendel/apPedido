package br.com.apPedido.model.domain;

public class PhysicalCustomer extends User{

	private int cpf;
	
	protected PhysicalCustomer(){}
	
	public PhysicalCustomer(String name, String address, String email) {
		super(name, address, email);
	}
	
	public PhysicalCustomer(String name, String address, String email, int cpf) {
		super(name, address, email);
		this.cpf = cpf;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
}
