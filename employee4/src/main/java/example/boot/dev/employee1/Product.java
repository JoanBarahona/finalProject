package example.boot.dev.employee1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String brand;
	private String model;
	private String type;
	private double price;
	private String description;
	
		
	public Product() {
		super();
	}


	public Product(int id, String brand, String model, String type, double price, String description) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.price = price;
		this.description = description;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", model=" + model + ", type=" + type + ", price=" + price
				+ ", description=" + description + "]";
	}
	
	
	
	
	
	
	
	

}
