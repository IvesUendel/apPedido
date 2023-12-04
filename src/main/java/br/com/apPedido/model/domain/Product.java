package br.com.apPedido.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double value;
	private int product_code;
	private String description;
	private String type;
	private double weight;
	private int quantity;
	private String ingredients;
	private String name;
	
	public Product() {}
	
	public Product(String name, double value, int product_code, String description, String type, double weight, int quantity,
			String ingredients) {
		this.name = name;
		this.value = value;
		this.product_code = product_code;
		this.description = description;
		this.type = type;
		this.weight = weight;
		this.quantity = quantity;
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return String.format("Name: (%s) - Value: (%.2f) - Product Code: (%d) - Description: (%s) - Type: (%s) - Weight: (%.2f) - "
				+ "Quantity: (%d) - Ingredients: (%s)", name, value, product_code, description, type, weight, quantity, ingredients);
	}
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
			
}
