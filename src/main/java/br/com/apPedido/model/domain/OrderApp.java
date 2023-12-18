package br.com.apPedido.model.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderApp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate order_date;
	private String description;
	private int order_code;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idUser")
	private User user;
	
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	//@JoinColumn(name = "idOrderApp")
	private List<Product> products;
	
	public OrderApp() {}
			
	public OrderApp(LocalDate order_date, String description, int order_code) {
		super();
		this.order_date = order_date;
		this.description = description;
		this.order_code = order_code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getOrder_date() {
		return order_date;
	}
	
	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getOrder_code() {
		return order_code;
	}
	
	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	@Override
	public String toString() {
		return String.format("ID: (%d) - Descripction: (%s) - Order Date: (%s) - Order Code: (%d) - User: (%s) - Products: (%s)", 
				id, description, order_date, order_code, user, products);
	}
	
}
