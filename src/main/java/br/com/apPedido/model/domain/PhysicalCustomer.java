package br.com.apPedido.model.domain;

public class PhysicalCustomer extends User{

	private int cpf;
	
	/*public PhysicalCustomer(String name, String address, String email, int cpf) {
		super(name, address, email);
		this.cpf = cpf;
	}*/

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
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s - CPF: (%d)", super.toString(), cpf);
	}
		
}
