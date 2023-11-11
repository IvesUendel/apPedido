package br.com.apPedido.model.domain;

public class Product {

	private double value;
	private int product_code;
	private String description;
	private String type;
	private double weight;
	private int quantity;
	private String ingredients;
	
	public Product() {}
	
	public Product(double value, int product_code, String description, String type, double weight, int quantity,
			String ingredients) {
	
		this.value = value;
		this.product_code = product_code;
		this.description = description;
		this.type = type;
		this.weight = weight;
		this.quantity = quantity;
		this.ingredients = ingredients;
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
			
}
