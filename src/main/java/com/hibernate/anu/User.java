package com.hibernate.anu;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@ToString
@Getter
@Setter
@Cacheable  
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE,region="User") 
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int UserId;

	
	@Column(name="username")
	String Username;
	@Column(name = "address")
	String Address;
	@Column(name = "salary")
    int salary;
	
	//generating getter and setter methods
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", Username=" + Username + ", Address=" + Address + ", salary=" + salary
				+ "]";
	}
	


}
