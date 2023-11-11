package br.com.apPedido.model.domain;

import java.time.LocalDate;

public class Order {

	private LocalDate order_date;
	private String description;
	private int order_code;
	
	public Order() {}
			
	public Order(LocalDate order_date, String description, int order_code) {
		super();
		this.order_date = order_date;
		this.description = description;
		this.order_code = order_code;
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
	
}
