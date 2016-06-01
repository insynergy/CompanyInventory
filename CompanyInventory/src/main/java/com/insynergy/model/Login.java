package com.insynergy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;




import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "login")
@SuppressWarnings("serial")
public class Login implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "id", length = 11 )
	
	private int id;
	
	@NotEmpty(message = "Please enter UserName")
	private String uname;
	private String pwd;
	@NotEmpty(message = "Please enter Password")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
/*	@Override
	public String toString(){
		return "id="+id+","
				+ " userName="+userName+
				", password="+password;
	}*/


