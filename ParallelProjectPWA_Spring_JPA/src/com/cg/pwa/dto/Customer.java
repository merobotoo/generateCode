package com.cg.pwa.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Customer")
public class Customer 
{
	@Column(name="Cust_name")
	@Size(min = 3, max = 20, message = 
			   "Username must be between 3 and 20   characters long.")
	@Pattern(regexp = "^[A-Z]{1}[a-z]{1,10}", message = 
                   "Name invalid! Name should start with capital letter and should be of minimum 2 characters")
	@NotEmpty(message="Name should not be empty")
	private String custName;
	
	@Id
	@Column(name="Cust_mobile",length=10)
	@Size(min = 10, max = 10, message = 
			   "Mobile number must be 10 characters long")
	@Pattern(regexp = "^[6789][0-9]{9}", message = 
          "Mobile Number Invalid! Please enter valid Indian mobile number of 10 digits e.g 9867988985")
	@NotNull(message="Mobile Number should not be blank")
	private String custMobile;
	
	@Column(name="Cust_age",length=10)
	@NotNull(message="Age should not be blank")
	private float custAge;
	
	@Column(name="Cust_amount",length=10)
	@NotNull(message="Amount should not be null")
	private double custInitialBalance;
	
	public String getCustName() 
	{
		return custName;
	}
	public void setCustName(String custName) 
	{
		this.custName = custName;
	}
	public String getCustMobile() 
	{
		return custMobile;
	}
	public void setCustMobile(String custMobile) 
	{
		this.custMobile = custMobile;
	}
	public float getCustAge() 
	{
		return custAge;
	}
	public void setCustAge(float custAge) 
	{
		this.custAge = custAge;
	}
	public double getCustInitialBalance() 
	{
		return custInitialBalance;
	}
	public void setCustInitialBalance(double custInitialBalance) 
	{
		this.custInitialBalance = custInitialBalance;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
