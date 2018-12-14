package com.cg.pwa.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Transactions")
public class Transactions {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int index;
	
	@Column(name="mobileno")
	private String custMobile;
	
	@Column(name="creditORdebit")
	private String creditdebit;
	
	@Column(name="Balance")
	private double balance;
	
	@Column(name="amount")
	private double transactionamount;
	
	@Column(name="transtime")
	private String date;

	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public String getCreditdebit() {
		return creditdebit;
	}

	public void setCreditdebit(String creditdebit) {
		this.creditdebit = creditdebit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getTransactionamount() {
		return transactionamount;
	}

	public void setTransactionamount(double transactionamount) {
		this.transactionamount = transactionamount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Transactions [index=" + index + ", custMobile=" + custMobile
				+ ", creditdebit=" + creditdebit + ", balance=" + balance
				+ ", transactionamount=" + transactionamount + ", date=" + date
				+ "]";
	}

	public Transactions(int index, String custMobile, String creditdebit,
			double balance, double transactionamount, String date) {
		super();
		this.index = index;
		this.custMobile = custMobile;
		this.creditdebit = creditdebit;
		this.balance = balance;
		this.transactionamount = transactionamount;
		this.date = date;
	}
	
	
}
