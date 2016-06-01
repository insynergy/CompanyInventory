package com.insynergy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="INVENTORY")
public class Inventory {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Please enter name.")
	private String name;
	
	//@NotEmpty(message = "Please enter count.")
	private int count;
	
	@NotEmpty(message = "Please enter model.")
	private String model;
	
	@NotEmpty(message = "Please enter serialNo.")
	private String serialNo;
	
	@NotEmpty(message = "Please enter make.")
	private String make;
	
	//@NotEmpty(message = "Please enter price.")
	private double price;
	
	//@NotEmpty(message = "Please enter price.")
	private String date;
    
	
	private String remarks;
	
//	private int otp;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	@Override
	public String toString(){
		return "id="+id+","
				+ " name="+name+
				", count="+count+
				", model="+model+ 
				", serialNo="+serialNo+
				", make="+make+
				", date="+date+
				", price="+price+
		        ", remarks="+remarks;
		      //" otp="+otp;
	}
}
