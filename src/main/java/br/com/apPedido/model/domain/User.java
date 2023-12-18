package br.com.apPedido.model.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(value = LegalCustomer.class, name = "LegalCustomer"),
	@JsonSubTypes.Type(value = PhysicalCustomer.class, name = "PhysicalCustomer"),
	@JsonSubTypes.Type(value = Seller.class, name = "Seller")
})
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String address;
	private String email;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idAddress")
	private Address brazilAddress;
	
	public User() {}
	
	public User(String name, String address, String email) {
		this.name = name;
		this.address = address;
		this.email = email;
	}
	
	public User(String name, String address, String email, Address brazilAddress) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.brazilAddress = brazilAddress;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getBrazilAddress() {
		return brazilAddress;
	}

	public void setBrazilAddress(Address brazilAddress) {
		this.brazilAddress = brazilAddress;
	}

	@Override
	public String toString() {
		return String.format("Name: (%s) - Address: (%s) - E-mail: (%s)", name, address, email);
	}
	
}
