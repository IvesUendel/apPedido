package br.com.apPedido.model.domain;

public class LegalCustomer extends User{

	private int cnpj;
	
	protected LegalCustomer() {}
	
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

}
